package points;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculations {

    private PointsPlane plane;
    private static Map<Point, Point> outMap = new HashMap<Point, Point>();
    
    Calculations(PointsPlane plane) {
        this.plane=plane;
    }

    public Map<Point, Point> getMap() {
        return outMap;
    }

    public static void getNearestPoints(List<Thread> threadList) throws InterruptedException {
        
        for (int i=0; i<threadList.size();i++){
            System.out.println(i + "for1");
            threadList.get(i).start();
        }
        
        for (int i=0;i<threadList.size();i++) {
            System.out.println(i + "for2");
            threadList.get(i).join();
        }
    }

    public void doCalculations(PointsPlane plane, int indexFrom, int indexTo, Map<Point, Point> outMap) {

        Point current;
        Point nearest;

        for (int i = indexFrom; i < indexTo; i++) {
            current = plane.listOfPoints.get(i);
            nearest = plane.findNearest(current);
            outMap.put(current, nearest);
        }

    }

    public static void main(String[] args) throws InterruptedException {

        double start = System.currentTimeMillis();
        
        PointsPlane plane = new PointsPlane();
        Calculations calc = new Calculations(plane);

        final int threadsNumber = 4;
        
        List<Thread> listOfThreads = new ArrayList<Thread>(threadsNumber);
        int sizePointsList = plane.getPoints().size(); 
        int perThread = sizePointsList /threadsNumber;
        
        for ( int i = 0; i < threadsNumber ; i++) {
            
            int startIndex = i * perThread;
            int endIndex = (i + 1) * perThread - 1;
            
            if (i == threadsNumber - 1)
                endIndex = sizePointsList - 1;
            System.out.println("start-" + startIndex + " end-" + endIndex);
            Thread curr = new Thread (new PointsThread(calc,plane, startIndex, endIndex));
            listOfThreads.add(curr);
            
        }
        System.out.println("size threads="+listOfThreads.size());
        getNearestPoints(listOfThreads);
        
        System.out.println(outMap.size());

        double end = System.currentTimeMillis();
        
        System.out.println("time needed: " + (end - start));

        // one thread : 106617.0
        // two threads: 56470.0
        // tree threads: 38644.0
        // four threads: 29906.0
    }
}
