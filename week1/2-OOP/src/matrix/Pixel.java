package matrix;

public class Pixel {
    
    private float R;
    private float G;
    private float B;
    
    Pixel (float r,float g,float b) {
        
        this.R = r;
        this.G = g;
        this.B = b;
    }
    public float getR() {
        return R;
    }
    public void setR(float r) {
        R = r;
    }
    public float getG() {
        return G;
    }
    public void setG(float g) {
        G = g;
    }
    public float getB() {
        return B;
    }
    public void setB(float b) {
        B = b;
    }
    
    public float getRGB () {
        return (R + G + B)/3; 
    }
    
    
}

