package matrixes;

public class Matrix {
    private double arrayMatrix[][];

    public Matrix(double arrayMatrix[][]) {
        this.arrayMatrix = arrayMatrix;
    }

    public Matrix() {
        // this.arrayMatrix = new double[50][50];
    }

    public int getLines() {
        return arrayMatrix[0].length;
    }

    public int getColumns() {
        return arrayMatrix.length;
    }

    public double[][] getMatrix() {
        return arrayMatrix;
    }

    public void setMatrix(double[][] matrix) {
        this.arrayMatrix = matrix;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < arrayMatrix.length; i++) {
            for (int j = 0; j < arrayMatrix[i].length; j++) {
                res.append(arrayMatrix[i][j] + " ");
            }
            res.append('\n');
        }
        return res.toString();
    }

}
