/**
 * 
 */
package chrome_dino;

/**
 * @author George
 *
 */
public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
