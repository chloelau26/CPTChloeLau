import arc.*;

public class testing2{
	public static void main(String[] args){
		Console con = new Console();	
		
		int intRow;
		int intRow2;
		int intRandom;
		int intCount;
		int intTrack;
		int intTest;
		
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
							for(intTest = 0; intTest <= intLength - 1; intTest++){
								if (intTest != intRow && !strIndex[intRow].equals(strIndex[intTest])) {
									intTrack++;
								}
							}
							
							if (intTrack == intLength - 1) {
								blnDiffIndex = true;
							}
						}
					}
				}
				
				
				
			// System
			for(intRow = 0; intRow < intLength; intRow++){
				System.out.println(strIndex[intRow]);
			}
				
			}
		}
			
		
			
	}
}
