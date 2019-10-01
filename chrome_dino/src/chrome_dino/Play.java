/**
 * 
 */
package chrome_dino;

import java.awt.AWTException;
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
	private KeyInterface keys;
	
	int[] bbox1 = {28,216,1905,737};
	
	public Play() {
		
		keys = new KeyInterface();
	}
	
	public void play_game() {
		
		
		start_play();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int x=0; x<20; x++) {
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
		long height = 0;
		long jumpTime = 0;
		
		int[][] pix = this.keys.take_screen(bbox1, 0);
		
		
		
		
		
		
		long[] heightJump = {height, jumpTime};
		
		this.keys.close_game();
		
		return heightJump;
	}
	


}
