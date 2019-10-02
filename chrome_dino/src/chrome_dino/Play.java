 /**
 * 
 */
package chrome_dino;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.JComboBox.KeySelectionManager;

/**
 * @author George
 * Code to play the chrome dinosaur game
 */
public class Play {

	/**
	 * @param args
	 * @throws AWTException chrome
	 * @throws InterruptedException 
	 */
	
	private int DINOWIDTH = 128;
	private int DINOHEIGHT = 138;
	private int DINODROP = 8; // pixels the mouth is lower than the top of the height
	private int DINOX = 160;
	private int DINOY = 364;
	private KeyInterface keys;
	
	int[] bbox1 = {28,216,1905,737};
	
	public Play() {
		
		keys = new KeyInterface();
	}
	
	public void play_game() throws AWTException {
		
		
		start_play();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ScreenThread t = new ScreenThread();
		t.start();
		t.yield();
		
		JumpThread s = new JumpThread();
		s.start();
		s.yield();
		
	}
	
	public void test_jump(long ms) throws AWTException {
		start_play();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.keys.take_screen(bbox1, 0);
		
		JumpThread t = new JumpThread();
		Robot r1 = new Robot();
		t.run(r1, ms);
		for (int x=1; x<20; x++) {
			this.keys.take_screen(bbox1, x);
		}
		
		
	}
	
	private void start_play() {
		try {
			this.keys.load_game();
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public long[] determine_jump(long ms) {
		start_play();
		long height = 100000;
		long jumpTime = 0;
		long startTime = -1;
		int r,g,b;
		int[][] pix;
		
		int[][][] pixArray = new int[10][][];
		
		for (int h=0;h<10;h++) {
			pix = this.keys.take_screen(bbox1, h);
			pixArray[h] = pix;
			if (h==0) {
				this.keys.jump_press(ms);
			}
		}
		
		int time = 0;
		boolean done = false;
		boolean jumped = false;
		int[] path = new int[10];
		while (! done) {
			pix = pixArray[time];
			int y = 0;
			int highest = -1;
			//System.out.println(time);
			
			while (y<bbox1[3]-bbox1[1] && highest == -1) {
				
				Color square = new Color(pix[DINOX][y]);
				r = square.getRed();
				g = square.getGreen();
				b = square.getBlue();
				if (r == 83 && g == 83 && b == 83) {
					highest = y;
					path[time] = y;
					//System.out.println(y);
					if (highest < height) {
						height = highest;
					}
				}
				y++;
				
			}
			
			if (path[time] == path[0] && time != 0) {
				if (jumped) {
					done = true;
					jumpTime = time-startTime;
				}
				else {
					jumped = true;
					
				}
			}
			else {
				if (startTime == -1 && time != 0) {
					startTime = time-1;
				}
			}
			
			time++;
			
			
		
		}
		
		/*
		System.out.print('[');
		for (int i=0;i<path.length;i++) {
			System.out.print(path[i]);
			System.out.print(',');
		}
		System.out.println(']');
		*/
		
		
		
		
		long[] heightJump = {height, jumpTime, startTime};
		
		this.keys.close_game();
		/*
		System.out.print("height: ");
		System.out.println(height);
		System.out.print("jumpTime: ");
		System.out.println(jumpTime);
		System.out.print("startTime: ");
		System.out.println(startTime);
		*/
		
		return heightJump;
	}
	


}
