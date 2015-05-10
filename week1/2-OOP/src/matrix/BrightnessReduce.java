package matrix;

public class BrightnessReduce implements MatrixOperation {

    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        float oldR = matrix[x][y].getR();
        float oldG = matrix[x][y].getG();
        float oldB = matrix[x][y].getB();
        
        Pixel newPixel = new Pixel(oldR-10,oldG - 10, oldB - 10);
        
        return newPixel;
    }

}
