package chrome_dino;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

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
	

	
}
