package points;


public class PointsThread implements Runnable {

    private Calculations calc;
    private PointsPlane plane;
    private int indexFrom, indexTo;

    public PointsThread(Calculations calc, PointsPlane plane,int indexFrom, int indexTo) {
        
        this.calc = calc;
        this.plane = plane;
        this.indexFrom = indexFrom;
        this.indexTo = indexTo;
 
    }

    @Override
    public void run() {
        System.out.println("thread is working");
        calc.doCalculations(plane,indexFrom, indexTo, calc.getMap());
    }

}
