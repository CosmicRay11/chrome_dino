package chrome_dino;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class KeyInterface {
	
	Robot r;
	
	public KeyInterface() {

		try {
			this.r = new Robot();
			//r.keyPress(KeyEvent.VK_SPACE);
			//TimeUnit.SECONDS.sleep(2);
			//r.keyRelease(KeyEvent.VK_SPACE);
			
		} catch (AWTException e) {
			e.printStackTrace();
		} 
	}
	
	public void jump_press(long ms) {
		this.r.keyPress(KeyEvent.VK_SPACE);
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.r.keyRelease(KeyEvent.VK_SPACE);
	}
	
	public void duck_press(long ms) {
		this.r.keyPress(KeyEvent.VK_DOWN);
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.r.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public void load_game() throws AWTException, InterruptedException {
		load_chrome();
		Thread.sleep(1000);
		click(262,63);
		Thread.sleep(1000);
		type_url();
		Thread.sleep(1000);
		jump_press(50);
		this.r.mouseMove(1000, 800);  
		Thread.sleep(2500);
		
	}
	
	public void load_chrome() {
		try {
		    Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		    p.waitFor();
		    System.out.println("Google Chrome launched!");
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public void click(int x, int y) throws AWTException{
	    this.r.mouseMove(x, y);    
	    this.r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	    this.r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	public void type_url() {
		//chrome://dino
		int[] word = {KeyEvent.VK_C, KeyEvent.VK_H, KeyEvent.VK_R, KeyEvent.VK_O, KeyEvent.VK_M, KeyEvent.VK_E, KeyEvent.VK_SEMICOLON,
				     KeyEvent.VK_SLASH, KeyEvent.VK_SLASH, KeyEvent.VK_D, KeyEvent.VK_I, KeyEvent.VK_N, KeyEvent.VK_O, KeyEvent.VK_ENTER};
		
		for (int let=0; let<word.length; let++) {
			if (let != 6) {
				this.r.keyPress(word[let]);
				this.r.keyRelease(word[let]);
			}
			else {
				this.r.keyPress(KeyEvent.VK_SHIFT);
				this.r.keyPress(word[let]);
				
				this.r.keyRelease(word[let]);
				this.r.keyRelease(KeyEvent.VK_SHIFT);
			}
		}
	}

	public void close_game() {
		this.r.keyPress(KeyEvent.VK_CONTROL);
		this.r.keyPress(KeyEvent.VK_W);
		
		this.r.keyRelease(KeyEvent.VK_W);
		this.r.keyRelease(KeyEvent.VK_CONTROL);	
	}
	
	public void take_screen() {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = this.r.createScreenCapture(screenRect);
		try {
			ImageIO.write(capture, "bmp", new File("dino_screen"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
}
