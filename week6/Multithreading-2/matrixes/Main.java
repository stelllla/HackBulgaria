package matrixes;

public class Main {

    public static void main(String[] args) throws Exception {
        double[][] list1 = new double[1000][1000];
        double[][] list2 = new double[1000][1000];

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list1[i].length; j++) {
                list1[i][j] = 2;
            }
        }
        for (int i = 0; i < list2.length; i++) {
            for (int j = 0; j < list2[i].length; j++) {
                list2[i][j] = 3;
            }
        }

        Matrix lMatrix = new Matrix(list1);
        Matrix rMatrix = new Matrix(list2);

        MatrixMultiplication m = new MatrixMultiplication(lMatrix, rMatrix);
        m.multiplyMatrixParallel(2);

        if (m.getResMatrix() != null) {
            System.out.println("The result is ready!");
            //System.out.println(m.getResMatrix());
        } else {
            System.out.println("Invalid input!");
        }
    }
}

// 1: 14073  2:8287 3:7100 
