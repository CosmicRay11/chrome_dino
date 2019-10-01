package chrome_dino;

public class Start {

	public static void main(String[] args) {
		Play player = new Play();
		
		
		
		for (int ms=5; ms<=1000; ms = ms+5) {
			long[] heightJump = player.determine_jump(ms);
			long height = heightJump[0];
			long jumpTime = heightJump[1];
			long startDelay = heightJump[2];
			
			System.out.print("\nmilliseconds: ");
			System.out.println(ms);
			System.out.print("height: ");
			System.out.print(height);
			System.out.print(" / jump time: ");
			System.out.print(jumpTime);
			System.out.print(" / start delay: ");
			System.out.print(startDelay);
			
		}
		
		
		//player.play_game();

	}

}
