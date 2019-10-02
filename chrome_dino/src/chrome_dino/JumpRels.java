package chrome_dino;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class JumpRels {
	
	String jumpRelPath = "jump_rels.txt";
	int msJumps = 5;
	int numberOfJumps = 100;

	public JumpRels() {
		//double[][] jumpData = determine_all_jump_rels();
	}
	
	public double[][] get_jump_rels(boolean saved) {
		double[][] jumpData;
		if (saved) {
			jumpData = unpack_jump_rels();
		}
		else {
			jumpData = determine_all_jump_rels();
			save_jump_rels(jumpData);
		}
		return jumpData;
	}
	
	public double[][] determine_all_jump_rels() {
		
		Play player = new Play();
		
		int repetitions = 10;
		
		double[][] data = new double[numberOfJumps][2];
		
		
		for (int ms=msJumps; ms<msJumps*numberOfJumps; ms = ms+msJumps) {
			long heightSum = 0;
			long jumpTimeSum = 0;
			System.out.println(ms);
			for (int rep=0;rep<repetitions;rep++) {
				long[] heightJump = player.determine_jump(ms);
				heightSum += heightJump[0];
				jumpTimeSum += heightJump[1];
			}
			double avHeight = (float) heightSum / repetitions;
			double avJumpTime =  (float) jumpTimeSum / repetitions;
			
			double[] miniData = {avHeight, avJumpTime};
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
				writer.println("");
				writer.print(data[entry][1]);
				writer.println("");
			}
			
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double[][] unpack_jump_rels() {
		double[][] jumpData = new double[numberOfJumps][2];
		FileReader fileReader;
		try {
			fileReader = new FileReader(jumpRelPath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line1,line2;
            
			try {
				for (int entry=0;entry<numberOfJumps;entry++) {
					line1 =  bufferedReader.readLine();
					line2 =  bufferedReader.readLine();
					if (line1 != null) {
						jumpData[entry][0] = Double.parseDouble(line1);
						jumpData[entry][1] = Double.parseDouble(line2);
					}
					
				}
			} catch (IOException e) {
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
