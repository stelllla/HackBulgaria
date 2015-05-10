package matrix;

public class GaussianBlur implements MatrixOperation {

    public boolean isOutOfBounds(int x, int y, Pixel[][] matrix) {
        return (x < 0 || y < 0 || x > matrix.length || y > matrix[0].length);
    }

    public float[] average(int x, int y, Pixel[][] matrix) {

        int sumR = 0, sumG = 0, sumB = 0, count = 0;
        float[] arr = new float[3];

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!isOutOfBounds(i, j, matrix) && i != x && j != y) {
                    sumR += matrix[i][j].getR();
                    sumG += matrix[i][j].getG();
                    sumB += matrix[i][j].getB();
                    count++;
                }
            }
        }
        arr[0] = sumR / count;
        arr[1] = sumG / count;
        arr[3] = sumB / count;
        return arr;
    }

    @Override
    public Pixel withPixel(int x, int y, Pixel[][] matrix) {

        float[] arr = average(x, y, matrix);
        float newR = arr[0];
        float newG = arr[1];
        float newB = arr[2];

        Pixel newPixel = new Pixel(newR, newG, newB);
        return newPixel;
    }

}
