package chrome_dino;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class GetJumpRels {
	
	String jumpRelPath = "jump_rels.txt";
	int msJumps = 5;
	int numberOfJumps = 100;

	public GetJumpRels() {
		//double[][] jumpData = determine_all_jump_rels();
		double[][] jumpData = {{1,2,3}, {5,4,6}};
		save_jump_rels(jumpData);
	}
	
	public double[][] determine_all_jump_rels() {
		
		Play player = new Play();
		
		int repetitions = 10;
		
		double[][] data = new double[numberOfJumps][3];
		
		
		for (int ms=msJumps; ms<msJumps*numberOfJumps; ms = ms+msJumps) {
			long heightSum = 0;
			long jumpTimeSum = 0;
			long startDelaySum = 0;
			for (int rep=0;rep<repetitions;rep++) {
				long[] heightJump = player.determine_jump(ms);
				heightSum += heightJump[0];
				jumpTimeSum += heightJump[1];
				startDelaySum += heightJump[2];
			}
			double avHeight = (float) heightSum / repetitions;
			double avJumpTime =  (float) jumpTimeSum / repetitions;
			double avStartDelay =  (float) startDelaySum / repetitions;
			
			double[] miniData = {avHeight, avJumpTime, avStartDelay};
			data[ms/msJumps] = miniData;
		}
		return data;
		
	}
	
	public static void save_jump_rels(double[][] data) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("jump_rels.txt", "UTF-8");
			for (int entry=0;entry<data.length;entry++) {
				writer.print(data[entry][0]);
				writer.print(',');
				writer.print(data[entry][1]);
				writer.print(',');
				writer.print(data[entry][2]);
				writer.print('!');
			}
			
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double[][] unpack_jump_rels() {
		double[][] jumpData = new double[numberOfJumps][3];
		
		FileReader fileReader;
		try {
			fileReader = new FileReader(jumpRelPath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            
			try {
				while((line  = bufferedReader.readLine()) != null) {
				    System.out.println(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   

            // Always close files.
            bufferedReader.close();      
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jumpData;
	}
		
		
		//player.play_game();

}
