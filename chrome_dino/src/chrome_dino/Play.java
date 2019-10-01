/**
 * 
 */
package chrome_dino;

import java.awt.AWTException;

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
	
	int DINOWIDTH = 128;
	int DINOHEIGHT = 138;
	int DINODROP = 8; // pixels the mouth is lower than the top of the height
	KeyInterface keys;
	
	public Play() {
		
		keys = new KeyInterface();
	}
	
	public void start_play() {

		try {
			this.keys.load_game();
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public long[] determine_jump(long ms) {
		long height = 0;
		long jumpTime = 0;
		
		this.keys.take_screen();
		
		
		long[] heightJump = {height, jumpTime};
		
		return heightJump;
	}
	


}
