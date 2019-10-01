package chrome_dino;

public class Start {

	public static void main(String[] args) {
		Play player = new Play();
		
		player.play_game();
		
		
		/**
		for (int ms=5; ms<=1000; ms = ms+5) {
			long[] heightJump = player.determine_jump(ms);
			long height = heightJump[0];
			long jump = heightJump[1];
			
			String outstring = "jump time: " + Integer.toString(ms) + "ms / height: " + Long.toString(height) + "pix / jump time: " + Long.toString(jump);
			System.out.println(outstring);
			
		}
		 */
		
		
		//player.play_game();

	}

}
