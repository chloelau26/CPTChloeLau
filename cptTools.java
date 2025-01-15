import arc.*;

public class cptTools{
	public static char menu(Console con){		
		// Variables
		char chrChoice; 
		
		// Output Option
		con.println(" Play Game (p)");
		con.println(" View High Score (v)");
		con.println(" Quit (q)");
		con.println(" Help (h)");
		
		// User Decision
		con.print(" Enter Choice: ");
		chrChoice = con.getChar();
		// con.println(chrChoice);
		return chrChoice;
	}
	
	public static void quit(Console con){
		con.clear();
		con.println(" Game Exiting...");
		con.clear();
		con.sleep(1000);
		con.closeWindow();
	}
	
	public static void secretMenu(Console con){
		int intRandom = (int) (Math.random()*5 + 1);
		// on top of the scrambled word (layer placed on top of the scrambled word)
		
		// joke result correspond to joke number generated
		if(intRandom == 1){
			con.println(" How do trees get on the Internet?");
			con.sleep(100);
			con.println(" They log in!");
		}else if(intRandom == 2){
			con.println(" What do computers like to eat?");
			con.sleep(100);
			con.println(" Chips.");
		}else if(intRandom == 3){
			con.println(" What do elves learn in school?");
			con.sleep(100);
			con.println(" The elf-abet.");
		}else if(intRandom == 4){
			con.println(" Why do cows wear bells?");
			con.sleep(100);
			con.println(" Because their horns don’t work.");
		}else if(intRandom == 5){
			con.println(" Why did the bicycle fall over?");
			con.sleep(100);
			con.println(" Because it was two tired.");
		}
		
		// place the image back on top (only that section)
	}
	
	public static String theme(Console con){
		// Variable
		String strTheme;
			
		// Output Theme Option
		TextInputFile txtTheme = new TextInputFile("Theme.txt");
		int intRow = 1; 
		while(txtTheme.eof() == false){
			strTheme = txtTheme.readLine();
			con.println(intRow + ". " + strTheme);
			intRow++;
		}
		txtTheme.close();
			
		//Store User Decision
		con.print("Enter choice: ");
		strTheme = con.readLine();
		
		// transition screen
		con.sleep(100);
		con.clear();
				
		return strTheme;
	}
	
	public static void play(Console con){
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
		
		// Variables for strWords Array
		int intRow2;
		int intTestRow;
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
						for (intTestRow = 0; intTestRow <= intNum - 1; intTestRow++) {
							if (intTestRow != intRow && !strWords[intRow][1].equals(strWords[intTestRow][1])) {
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
		
		// print to debug (ensure all numbers in strWords array are unique)
		int intCount;
		System.out.println(" ");
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
			System.out.println(strWords[intCount][1]+" | "+strWords[intCount][0]);
		}
		
		
		
		
		
		
		
		
		

		int intOrder = 0;
		// set secret word
		String strSecret = strWords[intOrder][0]; 
		// length of word
		int intLength = strSecret.length(); 
		
		// Array to store letters and their random number
		String[][] strIndex = new String[intLength][2]; 

		// Initialize strIndex with letters and random numbers
		for (intRow = 0; intRow < intLength; intRow++) {
			// Store letters
			strIndex[intRow][0] = strSecret.substring(intRow, intRow + 1); 
			System.out.println(strIndex[intRow][0]);
			// Generate random number as string
			intRandom = (int) (Math.random() * 100 + 1); 
			strIndex[intRow][1] = Integer.toString(intRandom);
			System.out.println(strIndex[intRow][1]);
		}

		// Ensure all random numbers in strIndex are unique
		for (intRow = 0; intRow < intLength; intRow++) {
			for (intRow2 = 0; intRow2 < intLength; intRow2++) {
				// Compare only different row values
				if (intRow2 != intRow && strIndex[intRow][1].equals(strIndex[intRow2][1])) {
					blnDiffNum = false;
					while (!blnDiffNum) {
						intRandom = (int) (Math.random() * 100 + 1);
						strIndex[intRow][1] = Integer.toString(intRandom);

						// Reset intTrack
						intTrack = 0;
						for (intTestRow = 0; intTestRow < intLength; intTestRow++) {
							if (intTestRow != intRow && !strIndex[intRow][1].equals(strIndex[intTestRow][1])) {
								intTrack++;
							}
						}

						// If nothing repeats, exit loop
						if (intTrack == intLength - 1) {
							blnDiffNum = true;
						}
					}
				}
			}
		}

		// Print to debug (ensure all numbers are unique)
		System.out.println(" ");
		System.out.println("Uniqueness of Numbers");
		for (intCount = 0; intCount < intLength; intCount++) {
			System.out.println(strIndex[intCount][1]);
		}

		// Bubble sort based on random numbers
		for (intRow1 = 0; intRow1 < intLength - 1; intRow1++) {
			for (intRow2 = 0; intRow2 < intLength - intRow1 - 1; intRow2++) {
				if (Integer.parseInt(strIndex[intRow2][1]) > Integer.parseInt(strIndex[intRow2 + 1][1])) {
					// Store values greater into a temporary variable
					strTempName = strIndex[intRow2][0];
					strTempNum = strIndex[intRow2][1];

					// Right item moves to the left
					strIndex[intRow2][0] = strIndex[intRow2 + 1][0];
					strIndex[intRow2][1] = strIndex[intRow2 + 1][1];

					// Put temporary value to right
					strIndex[intRow2 + 1][0] = strTempName;
					strIndex[intRow2 + 1][1] = strTempNum;
				}
			}
		}

		// Print to debug (ensure numbers are sorted properly)
		System.out.println(" ");
		System.out.println("Bubble Sort");
		for (intCount = 0; intCount < intLength; intCount++) {
			System.out.println(strIndex[intCount][1] + " | " + strIndex[intCount][0]);
		}
		
		
		
		
	} //end of method
	
	
}
