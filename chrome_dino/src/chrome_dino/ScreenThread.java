package chrome_dino;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenThread extends Thread{

	public void run() {
		int x=0;
		
		int[] bbox = {28,216,1905,737};
		Robot r;
		try {
			r = new Robot();
		
			while (x!= -1) {
				
				System.out.println('b');
				
				int width = bbox[2] - bbox[0];
				int height = bbox[3] - bbox[1];
				Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				BufferedImage capture = r.createScreenCapture(screenRect);
				Graphics2D gra = capture.createGraphics();
				gra.draw(screenRect);
				capture = capture.getSubimage(bbox[0], bbox[1], width, height);
				
				try {
					ImageIO.write(capture, "bmp", new File("dino_screen" + Integer.toString(x) + ".bmp"));
					//System.out.println("dino_screen" + Integer.toString(save) + ".bmp");
				} catch (IOException e) {
			 	e.printStackTrace();
			 	 }
				x++;
			}
		
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
