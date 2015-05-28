package points;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointsPlane {
    
    List<Point> listOfPoints = new ArrayList<Point>(100_000);
    
    PointsPlane() {
        generatePoints();
    }
    
    public List<Point> getPoints() {
        return this.listOfPoints;
    }
    public List<Point> generatePoints() {
        Random rand = new Random();

        for (int i = 0; i < 100_000; i++) {
            int x = rand.nextInt(10_000);
            int y = rand.nextInt(10_000);

            Point p = new Point(x, y);
            listOfPoints.add(p);
        }

        return listOfPoints;
    }

    public double getDistance(Point left, Point right) {
        double expr = Math.pow(left.getX() - (right.getX()), 2) + Math.pow(left.getY() - (right.getY()), 2);
        return Math.sqrt(expr);
    }

    public Point findNearest(Point point) {
        double minDistance = Double.MAX_VALUE, currDistance = 0;
        int minPointIndex = 0;

        for (int i = 0; i < listOfPoints.size(); i++) {
            if (!listOfPoints.get(i).equals(point)) {
                currDistance = getDistance(point, listOfPoints.get(i));
                if (minDistance > currDistance) {
                    minPointIndex = i;
                    minDistance = currDistance;
                }
            }
        }

        return listOfPoints.get(minPointIndex);
    }
}
