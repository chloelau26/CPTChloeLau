import arc.*;

public class cptTools{
	//public static void introScreen(Console con){
		
	//}
	
	public static char menu(Console con){		
		// Variables
		char chrChoice; 
		
		// Output Option
		con.println("Play Game (p)");
		con.println("View High Score (v)");
		con.println("Quit (q)");
		con.println("Help (h)");
		
		// User Decision
		con.print("Enter Choice: ");
		chrChoice = con.getChar();
		con.println(chrChoice);
		return chrChoice;
	}
	
	public static String theme(Console con){
		// Variable
		String strTheme;
			
		// Output Theme Option
		TextInputFile txtTheme = new TextInputFile("Theme.txt");
		int intRow = 1; 
		while(txtTheme.eof() == false){
			txtTheme.readLine();
			intRow++;
		}
		txtTheme.close();
		
		String strThemeList[];
		strThemeList = new String[intRow];
		
		
		txtTheme = new TextInputFile("Theme.txt");
		int intCount = 0;
		while(txtTheme.eof() == false){
			strThemeList[intCount] = txtTheme.readLine();
			con.println((intCount + 1) + ". " + strThemeList[intCount]);
			intCount++;
		}

		// for(intCount = 1; intCount <
		con.println("1. Solar Systems");
		con.println("2. Greek Mythology");
		con.println("3. Countries");
		con.println("4. Formula 1");
		con.println("5. Chemical Element");
			
		//Store User Decision
		con.print("Enter choice: ");
		strTheme = con.readLine();
		
		// transition screen
		con.sleep(100);
		con.clear();
		
		return strTheme;
	}
	
	public static void storeWords(Console con){
		// open themes words from text file
		String strTheme = cptTools.theme(con);
		strTheme = strTheme + ".txt";
		TextInputFile list = new TextInputFile(strTheme);
				
		// count number of words in the theme file
		int intNum = 0;
		while(list.eof() == false){
			list.readLine();
			intNum++;
		}
		// ensure accuracy for number of words in theme text file
		System.out.println(intNum);
		list.close();
			
		// set up 2D array to input theme words into array
		String strWords[][];
		strWords = new String[intNum][2];
		
		// reopen same theme text file
		list = new TextInputFile(strTheme);
		int intRow;
		
		// store theme words into array
		int intRandom;
		for(intRow = 0; intRow < intNum; intRow++){
			strWords[intRow][0] = list.readLine();
			intRandom = (int)(Math.random()*100+1);
			strWords[intRow][1] = Integer.toString(intRandom);
			
			// print to debug (words and number assigned)
			System.out.println("Word added: " + strWords[intRow][0]);
			System.out.println(strWords[intRow][1]);
		}		
		list.close();
		
		// Variables for ensure uniqueness of each number
		int intRow2;
		int intTest;
		int intTrack = 0;
		boolean blnDiffNum;
		
		for (intRow = 0; intRow <= intNum - 1; intRow++) {
			for (intRow2 = 0; intRow2 <= intNum - 1; intRow2++) {
				// Compare only different row values
				if (intRow2 != intRow && strWords[intRow][1].equals(strWords[intRow2][1])) {
					blnDiffNum = false;
					while (!blnDiffNum) {
						intRandom = (int) (Math.random() * 100 + 1);
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
		
		// print to debug (ensure all numbers in array are unique)
		int intCount;
		System.out.println("Uniqueness of Number");
		for(intCount = 0; intCount < intNum; intCount++){
			System.out.println(strWords[intCount][1]);
		}
		
		// bubble sort words
		int intRow1;
		String strTempNum;
		String strTempName;
		for(intRow1 = 0; intRow1 < intNum - 1; intRow1++){
			for(intRow2 = 0; intRow2 < intNum - intRow1 - 1; intRow2++){
				if(Integer.parseInt(strWords[intRow2][1]) > Integer.parseInt(strWords[intRow2+1][1])){
					// store values greater into a temporary variable
					strTempName = strWords[intRow2][0];
					strTempNum = strWords[intRow2][1];
					
					// right item moves to the left
					strWords[intRow2][0] = strWords[intRow2+1][0];
					strWords[intRow2][1] = strWords[intRow2+1][1];
					
					// put temporary value to right
					strWords[intRow2+1][0] = strTempName;
					strWords[intRow2+1][1] = strTempNum;
				}
			}
		}
		
		// print to debug (ensure all number sorted properly)
		System.out.println(" ");
		System.out.println("Bubble Sort");
		for(intCount = 0; intCount < intNum; intCount++){
			System.out.println(strWords[intCount][1]);
		}
		
		// start of user game play
		boolean blnPlay = true;
		intCount = 0;
		String strSecret;
		int intLength;
		int intTry = 0;
		int intScore;
		while(blnPlay && intTry > -1){
			strSecret = strWords[intCount][0];
			intLength = strSecret.length();
			intTry = intLength - 4;
			
			// scamble word	
			String strScamble;
			

			
		
			
		}
		
	} //end of method
	
	
}
