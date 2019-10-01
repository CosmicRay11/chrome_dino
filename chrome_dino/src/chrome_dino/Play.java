/**
 * 
 */
package chrome_dino;

import java.awt.AWTException;

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
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		KeyInterface keys = new KeyInterface();
		
		//keys.jump_press(1000);

		keys.load_game();
		
		keys.close_game();
	}
	
	private static long[] determine_jump(long ms) {
		long height = 0;
		long jumpTime = 0;
		
		
		long[] heightJump = {height, jumpTime};
		
		return heightJump;
	}
	


}
