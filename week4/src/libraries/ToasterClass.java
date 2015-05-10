package libraries;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;




import com.nitido.utils.toaster.Toaster;


public class ToasterClass {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        Thread thread = new Thread();
        thread.start();
        Thread.sleep(15000);
        Toaster toasterManager = new Toaster();
        toasterManager.setToasterWidth(800);
        toasterManager.setToasterHeight(500);
        Color toasterColor = new Color(255,0,0);
        toasterManager.setToasterColor(toasterColor);
        
        
        BufferedImage backgroundImage = null;
        backgroundImage = ImageIO.read(new File("dog.jpg"));
        toasterManager.setBackgroundImage(backgroundImage);
        toasterManager.showToaster( "You should take a break,baby!" );
    }
}
