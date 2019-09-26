package chrome_dino;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class KeyInterface {
	
	public static boolean main(String[] args) {

		Robot r;
		boolean works;
		try {
			r = new Robot();
			//r.keyPress(KeyEvent.VK_SPACE);
			//TimeUnit.SECONDS.sleep(2);
			//r.keyRelease(KeyEvent.VK_SPACE);
			works = true;
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			works = false;
		} 
		
		return works;
	}
	
	
	
}
