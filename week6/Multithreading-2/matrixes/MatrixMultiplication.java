package matrixes;

public class MatrixMultiplication {

    private Matrix leftMatrix = new Matrix();

    private Matrix rightMatrix = new Matrix();

    private Matrix resMatrix = new Matrix();

    public MatrixMultiplication() {
    }

    public MatrixMultiplication(Matrix left, Matrix right) {

        setLeftMatrix(left);
        setRightMatrix(right);
        double[][] resArray = new double[left.getLines()][right.getColumns()];
        resMatrix = new Matrix(resArray);

    }

    public Matrix getLeftMatrix() {
        return leftMatrix;
    }

    public void setLeftMatrix(Matrix lMatrix) {
        this.leftMatrix = lMatrix;
    }

    public Matrix getRightMatrix() {
        return rightMatrix;
    }

    public void setRightMatrix(Matrix rMatrix) {
        this.rightMatrix = rMatrix;
    }

    public Matrix getResMatrix() {
        return resMatrix;
    }

    public void setResMatrix(Matrix resMatrix) {
        this.resMatrix = resMatrix;
    }

    private boolean checkMultiplicationPossible() {
        if (leftMatrix.getColumns() == rightMatrix.getLines()) {
            return true;
        } else {
            return false;
        }
    }

    public void multiplyFromTo(int startColumn, int endColumn) {
        double sum = 0;

        double[][] resArray = resMatrix.getMatrix();

        for (int i = startColumn; i  <= endColumn; i++) {
            for (int j = 0; j < rightMatrix.getLines(); j++) {
                for (int k = 0; k < leftMatrix.getLines(); k++) {
                    sum += leftMatrix.getMatrix()[i][k] * rightMatrix.getMatrix()[k][j];
                }

                resArray[i][j] = sum;
                sum = 0;
            }
        }

        resMatrix.setMatrix(resArray);
    }

    public void multiplyMatrixParallel(int numberOfThreads) throws Exception {
        if (checkMultiplicationPossible()) {
            long startTime = System.currentTimeMillis();
            Thread[] thread = new Thread[numberOfThreads];

            int perThread = rightMatrix.getColumns() / numberOfThreads;

            for (int i = 0; i < numberOfThreads; i++) {
                int startColum = i * perThread;
                int endColum = (i + 1) * perThread - 1;

                if (i == numberOfThreads - 1)
                    endColum = rightMatrix.getColumns() - 1;

                thread[i] = new Thread(new MultiplyThread(this, startColum, endColum));
            }

            for (int i = 0; i < numberOfThreads; i++) {
                thread[i].start();
            }

            for (int i = 0; i < numberOfThreads; i++) {
                thread[i].join();
            }

            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            System.out.println("time needed:" + timeElapsed);

        }

    }

}
