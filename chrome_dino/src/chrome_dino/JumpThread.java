package chrome_dino;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class JumpThread extends Thread {

	public void run(Robot r, long ms) {
		int x =0;
		while (x==0) {
		System.out.println('c');
		}
		r.keyPress(KeyEvent.VK_SPACE);
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		r.keyRelease(KeyEvent.VK_SPACE);
	}
}

	
