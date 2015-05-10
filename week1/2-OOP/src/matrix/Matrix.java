package matrix;

public class Matrix {

    private Pixel[][] matrix;

    Matrix(Pixel[][] matrix) {
        this.matrix = matrix;
    }

    public Pixel[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Pixel[][] matrix) {
        this.matrix = matrix;
    }

    public void operate(MatrixOperation op) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Pixel changed = op.withPixel(i, j, matrix);
                matrix[i][j] = changed;
            }
        }
    }

}
