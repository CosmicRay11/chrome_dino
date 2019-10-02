/**
 * 
 */
package chrome_dino;

import java.awt.AWTException;

/**
 * @author George
 *
 */
public class Start {

	/**
	 * @param args
	 * @throws AWTException 
	 */
	public static void main(String[] args) throws AWTException {
		Play player = new Play();
		player.play_game();
	
	}
	
	public static void do_jump_rels() {
		JumpRels j = new JumpRels();
		
		double[][] jumpRels = j.get_jump_rels(false);
		
		for (int i=0;i<jumpRels.length;i++) {
			for (int a=0;a<3;a++) {
				System.out.print(jumpRels[i][a]);
				System.out.print(" , ");
			}
			System.out.println("");
		}
	}
		

}
