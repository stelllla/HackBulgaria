import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import java.util.Scanner;

import javax.imageio.ImageIO;
 
// Class 
public class RGBToGrayScale {
 
 
	public static void convertTograyscale(String filename) throws IOException
	{ 
 
		BufferedImage image = null;

		image = ImageIO.read(new File(filename));
		
 
		if(image == null)
		{
			System.out.println("Failed to decode image!");
		}
 
		BufferedImage imgGray = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
 
		int rgbVal,
		    r,g,b,
		    newVal;

		for(int i=0; i < image.getWidth(); i++)
		{
			for(int j=0; j < image.getHeight(); j++)
			{
				rgbVal = image.getRGB(i,j);
				Color oldColor = new Color(rgbVal);
 
				r = oldColor.getRed();
				g = oldColor.getGreen(); 
				b = oldColor.getBlue();
				
				newVal = (r + g + b )/3;
				Color newColor = new Color(newVal, newVal, newVal);				
                int newColorRGB = newColor.getRGB();
				imgGray.setRGB(i,j,newColorRGB);
 
			}
		}
 
 
		try 
		{
			File file = new File("gray_image.jpg");
			ImageIO.write(imgGray, "jpeg", file);
		} 
		catch (IOException e)
		{
			System.out.println("Failed to write gray image!");
		}
	}
 
 
	public static void main(String[] args) throws IOException {
		
		System.out.println("Please, enter the image title : ");		
		Scanner sc = new Scanner (System.in);
		String filename = sc.nextLine();
		sc.close();
        
		try
		{
			convertTograyscale(filename);	
			System.out.println("The convert is ready!");
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("The file(image) doesn`t exist!");
		}
	}
 
}
