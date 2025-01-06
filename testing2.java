import arc.*;

public class testing2{
	public static void main(String[] args){
		Console con = new Console();	
		
		int intRow;
		
		// start of user game play
		boolean blnPlay = true;
		intCount = 0;
		String strSecret = "sodium";
		int intLength;
		int intTry = 0;
		int intScore;
		
		str
		
		while(blnPlay && intTry > -1){
			// strSecret = strWords[intCount][0];
			intLength = strSecret.length();
			intTry = intLength - 4;
			
			// scamble word	
			String strScamble;
			
			// 2D array for scramble word number
			for(intRow = 0; intRow < intLength; intRow++){
				
			}
			
			// TextInputFile txtWordIndex = new TextInputFile("Word Index.txt");
			for (intRow = 0; intRow <= intNum - 1; intRow++) {
				for (intRow2 = 0; intRow2 <= intNum - 1; intRow2++) {
					// Compare only different row values
					if (intRow2 != intRow && strWords[intRow][1].equals(strWords[intRow2][1])) {
						blnDiffNum = false;
						while (!blnDiffNum) {
							intRandom = (int) (Math.random() * intLength - 1);
							strWords[intRow][1] = Integer.toString(intRandom);

							// Reset intTrack
							intTrack = 0;
							for (intTest = 0; intTest <= intNum - 1; intTest++) {
								if (intTest != intRow && !strWords[intRow][1].equals(strWords[intTest][1])) {
									intTrack++;
								}
							}

							// if nothing repeats, exit loop
							if (intTrack == intNum - 1) {
								blnDiffNum = true;
							}
						}
					}
				}
			}
			
	}
}
