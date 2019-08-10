package invaders;

import java.util.List;

public class DetectInvaders {
	
	public static int detect(char[][] input, List<char[][]> invaders) {
		return detect(input, invaders, Commons.DETECT_INVADER_TRESHOLD);
	}
	
	/** returns the amount of invaders found in the given input
	 * 
	 * @param input
	 * @param invaders
	 * @return number of invaders found
	 */
	public static int detect(char[][] input, List<char[][]> invaders, int treshold) {
		if(input == null || input.length == 0 || input[0].length == 0 ) 
			return 0;
		
		if(treshold < 0 || treshold > 100)
			return 0;
		
		if(invaders == null || invaders.isEmpty())
			return 0;
		
		int invadersCount = 0;
		int rowCount = input.length;
		int columnCount = input[0].length;
		for(int i = 0; i < rowCount ; i++)
			for(int j = 0; j < columnCount; j++)
			{
				for(char[][] invader : invaders)
					invadersCount += isInvader(input, i, j, invader, treshold);
			}
		
		return invadersCount;
	}
	
	private static int isInvader(char[][] input, int i, int j, char[][] invader, int treshold) {
		if(input[i][j] != invader [0][0])
			return 0;
		
		// TODO: if invader does not fit anymore remove from list to make it more efficient
		if(i + invader.length-1 >= input.length 
				|| j + invader[0].length-1 >= input[0].length)
			return 0;
		
		int invaderSize = invader.length * invader[0].length;
		int matchingCount = 0;
		for(int x=0; x<invader.length; x++){
			for(int y=0; y<invader[0].length; y++){
				if(input[i + x][j + y] == invader[x][y])
					matchingCount++;
			}
		}
		return (matchingCount*100)/invaderSize >= treshold ? 1 : 0;
	}
}
