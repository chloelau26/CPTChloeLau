import arc.*;

public class testing2{
	public static void main(String[] args){
		Console con = new Console();	
		
		int intRow;
		int intRow2;
		int intRandom;
		int intCount;
		int intTrack;
		int intTestRow;
		
		// start of user game play
		boolean blnPlay = true;
		intCount = 0;
		String strSecret = "sodium"; // change
		int intLength;
		int intTryLeft = 0;
		int intScore;
		String strScamble;
		String strIndex[];
		boolean blnDiffIndex;
		int intRow3;
		int intOrder;
		
		
		while(blnPlay && intTryLeft > -1){
			// strSecret = strWords[intCount][0];
			intLength = strSecret.length();
			intTryLeft = intLength - 4;	
			strIndex = new String[intLength];		
			
			// initalize array
			for(intRow = 0; intRow < intLength; intRow++){
				strIndex[intCount] = Integer.toString(intLength);
			}
			
			
			// 2D array for scramble word number
			for(intRow = 0; intRow < intLength; intRow++){
				intRandom = (int) (Math.random() * (intLength - 1));
				strIndex[intRow] = Integer.toString(intRandom);
				
				for(intRow2 = 1; intRow < intLength; intRow2++){
					if(strIndex[intRow].equals(strIndex[intRow2])){
						blnDiffIndex = false;
						
						while(!blnDiffIndex){
							intRandom = (int) (Math.random() * (intLength - 1));
							strIndex[intRow] = Integer.toString(intRandom);
							
							intTrack = 0;
							for(intTestRow = 0; intTestRow < intLength; intTestRow++){
								if (intTestRow != intRow && !strIndex[intRow].equals(strIndex[intTestRow])) {
									intTrack++;
								}
							}
							
							// make sure it is not in chronological order
							
							if (intTrack == intLength) {
								blnDiffIndex = true;
							}
						}
					}
				}
			}
			
		}
		
			
			
			
			
			
	}
}
