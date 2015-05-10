package matrix;

public class Grayscale implements MatrixOperation {

    public Pixel withPixel(int x, int y, Pixel[][] matrix) {
        float oldR = matrix[x][y].getR();
        float oldG = matrix[x][y].getG();
        float oldB = matrix[x][y].getB();
        
        float newRGB = (oldR + oldG + oldB) /3;
        
        Pixel newPixel = new Pixel (newRGB,newRGB,newRGB);
        return newPixel;
    }
    

}
