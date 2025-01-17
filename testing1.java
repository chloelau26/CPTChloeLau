import arc.*;

public class cptTools{
	public static char menuOption(Console con){		
		// Variables
		char chrChoice; 
		
		// Output Option
		con.println(" Play Game (p)");
		con.println(" View High Score (v)");
		con.println(" Quit (q)");
		con.println(" Help (h)");
		
		// User Decision
		con.print(" Enter Choice: ");
		// chrChoice = con.getChar();
		chrChoice = con.readChar();
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
	
	public static void play(Console con, String strUserName){
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
		
		
		// begin game play
		int intOrder = 0;
		String strSecret;
		int intLength;
		boolean blnPlay = true;
		
		while(blnPlay){
			// set secret word
			strSecret = strWords[intOrder][0]; 
			// length of word
			intLength = strSecret.length(); 
			
			// Array to store letters and their random number
			String[][] strIndex = new String[intLength][2]; 

			// Initialize strIndex with letters and random numbers
			for (intRow = 0; intRow < intLength; intRow++) {
				// Store letters
				strIndex[intRow][0] = strSecret.substring(intRow, intRow + 1); 
				// Generate random number as string
				intRandom = (int) (Math.random() * 100 + 1); 
				strIndex[intRow][1] = Integer.toString(intRandom);
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
			
			// assembled the scrambled letter
			String strScramble;
			strScramble = "";
			for(intRow = 0; intRow < intLength; intRow++){
				strScramble = strScramble + strIndex[intRow][0];
			}
			System.out.println(strScramble);
			
			// variables for score system
			int intTry;
			intTry = intLength - 4;
			int intScore = 0;
			int intUnsolved = 0;
			
			// Game console appearance
			int intThemeLength = strTheme.length();
			String strGuess;
			con.println("Theme Selected: "+strTheme.substring(0, intThemeLength - 4));
			con.println("Username: "+strUserName);
			con.println(strScramble);
			con.println("Try Left: "+intTry);
			
			con.print("Enter Secret Word: ");
			strGuess = con.readLine();
			boolean blnCorrect = false;
			char chrChoice;
			
			// if statement for user decision during game play
			while(!blnCorrect){
				// access secret menu
				if(strGuess.equalsIgnoreCase("s")){
					con.println(" -------------------------------------------------------------------------");
					cptTools.secretMenu(con);
					con.println(" -------------------------------------------------------------------------");
					con.print("Enter Secret Word: ");
					strGuess = con.readLine();
					
				// user cheat
				}else if(strGuess.equalsIgnoreCase(strUserName)){
					intTry = intTry + 1;
					con.println(" -------------------------------------------------------------------------");
					con.println("Try Left Updated: "+intTry);
					con.print("Enter Secret Word: ");
					strGuess = con.readLine();
				
				}else if(intTry > 0){
					// guess word incorrectly
					if(!strGuess.equalsIgnoreCase(strSecret)){
						intTry--;
						if(intTry > 0){
							con.println("Try Left: "+intTry);
							con.print("Enter Secret Word: ");
							strGuess = con.readLine();
						}
						
					// guess word correctly
					}else if(strGuess.equalsIgnoreCase(strSecret)){
						blnCorrect = true;
						// score updated
						intScore = intOrder + 1;
						// intScore = intOrder + 1;
						// intScore = intScore ;
						con.clear();
						con.println("Solved!"); // need edits
						con.println(strScramble + " = "+ strSecret);
						con.println("Current Score: "+intScore);
						
						// user decision to continue
						con.print("Would you like to continue (y/n): ");
						chrChoice = con.readChar();
						
						// if statement when continued (yes)
						if(chrChoice == 'y'){ // statement need to be replicated below
							intOrder++;
							con.clear();
							// reach the end of word in theme
							if(intOrder >= intNum){
								con.println("No more words avaliable");
								// save high score
								TextOutputFile highScore = new TextOutputFile("highscore.txt",true); 
								highScore.println(intScore);
								highScore.close();
							
								// return it to main menu
								blnPlay = false;
								cptTools.menuOption(con);
							}
							
						// user decide to not continue (no)
						}else if(chrChoice == 'n'){
							// save high score
							TextOutputFile highScore = new TextOutputFile("highscore.txt",true); 
							highScore.println(intScore);
							highScore.close();
							
							// exit play game while loop & return to main menu						
							blnPlay = false;
							con.clear();
							cptTools.mainMenu(con);
						
						// invalid input for decision to continue
						}else if(chrChoice != 'n' && chrChoice != 'y'){
							con.sleep(100);
							con.clear();
							con.println(" Invalid Input");
							con.println(" Please Try Again");
							con.println(" -----------------------------------------------");
							con.print(" Would you like to continue (y/n): ");
							chrChoice = con.readChar();
							
							// invalid input (user decision to continue; decision is no)
							if(chrChoice == 'n'){
								// save high score
								TextOutputFile highScore = new TextOutputFile("highscore.txt",true); 
								highScore.println(intScore);
								highScore.close();
								
								// exit play game while loop & return to main menu						
								blnPlay = false;
								con.clear();
								cptTools.mainMenu(con);




							// invalid input (user decision to continue; decision is yes)
							}else if(chrChoice == 'y'){
								intOrder++;
								con.clear();
								// reach end of word in theme
								if(intOrder >= intNum){
									con.println("No more words avaliable");
									// save high score
									TextOutputFile highScore = new TextOutputFile("highscore.txt",true); 
									highScore.println(intScore);
									highScore.close();
								
									// return it to main menu
									blnPlay = false;
									cptTools.menuOption(con);
								}
								
							// invalid input 
							}else if(chrChoice != 'y' && chrChoice != 'n'){
								con.println(" -----------------------------------------------");
								con.println(" Too many invalid attempts. Return to main menu.");
								con.sleep(500);
								con.clear();
								blnPlay = false;
								cptTools.mainMenu(con);
							}
						}
					}
					
					
					
					
					
					
					}else{
						con.sleep(100);
						con.clear();
						con.println("Game over");
						// statement
						con.println(strScramble + " = "+ strSecret);
						con.println("Current Score: "+intScore);
						
						con.print("Would you like to continue (y/n): ");
						chrChoice = con.readChar();
						// same statement as the one above
						

					

				}
			}
		
		}
		
		
	} //end of method
	
	public static void mainMenu(Console con){
		// activate main menu 
		char chrChoice = cptTools.menuOption(con);
		boolean blnAvaliable = false;
		int intRetry;
		
		// if statement in a while loop to ensure option choose if avaliable and the different route based on user decision
		while(!blnAvaliable){
			if(chrChoice == 'p'){
				// play game option
				blnAvaliable = true;
				con.clear();
				
				// open text file to store user info
				TextOutputFile highScore = new TextOutputFile("highscore.txt",true); 
				
				// user input user info
				String strUser;
				con.print(" Enter username: ");
				strUser = con.readLine();
				
				// store into text file
				highScore.println(strUser);
				highScore.close();
				
				cptTools.play(con, strUser);
								
			}else if(chrChoice == 'v'){
				con.clear();
				cptTools.highScores(con);
				con.println("");
				
				// User decision to return to main menu
				con.print(" Return to main menu (m): ");
				chrChoice = con.readChar();
				if(chrChoice != 'm'){
					con.clear();
					// invalid input
					con.println(" Invalid Input");
					con.println(" Please Try Again");
					con.println(" -----------------------------------------------");
					con.print(" Return to main menu (m): ");
					chrChoice = con.readChar();
					if(chrChoice != 'm'){
						con.println(" -----------------------------------------------");
						con.println(" Too many invalid attempts. Game will now exit.");
						con.sleep(500);
						con.closeWindow();
					}
				}else if(chrChoice == 'm'){
					con.sleep(100);
					con.clear();
					cptTools.mainMenu(con);
				}
				
			}else if(chrChoice == 'q'){
				// quit option
				blnAvaliable = true;
				cptTools.quit(con);
				
			}else if(chrChoice == 'h'){
				// help option
				con.clear();
				con.println("Guess The Word");
				con.println(" 1. Select a Theme: A word will be randomly generated based on the selected theme.");
				con.println(" 2. Unscramble the Word: You must attempt to guess and unscramble the word within a ");
				con.println("    limited number of tries (displayed in the top left corner).");
				con.println(" 3. Scoring and Continuation: After solving the word, one point will be added to your score."); 
				con.println("    You will then have the option to either continue playing or quit the game.");
				
				con.println("");
				con.print(" Return to main menu (m): ");
				chrChoice = con.readChar();
				if(chrChoice != 'm'){
					con.clear();
					// invalid input
					con.println(" Invalid Input");
					con.println(" Please Try Again");
					con.println(" -----------------------------------------------");
					con.print(" Return to main menu (m): ");
					chrChoice = con.readChar();
					if(chrChoice != 'm'){
						con.println(" -----------------------------------------------");
						con.println(" Too many invalid attempts. Game will now exit.");
						con.sleep(500);
						con.closeWindow();
					}
				}else if(chrChoice == 'm'){
					con.sleep(100);
					con.clear();
					cptTools.mainMenu(con);
				}
				
			}else{
				con.sleep(100);
				con.clear();
				con.println(" Invalid Input");
				con.println(" Please Try Again");
				con.println(" -----------------------------------------------");
				chrChoice = cptTools.menuOption(con); 
				
				if(chrChoice != 'p' && chrChoice != 'v' && chrChoice != 'q' && chrChoice != 'h'){
					con.clear();
					con.println("Invalid Input");
					con.println("Please Try Again");
					con.println("-----------------------------------------------");
					chrChoice = cptTools.menuOption(con); 
					if(chrChoice != 'p' && chrChoice != 'v' && chrChoice != 'q' && chrChoice != 'h'){
						con.println("");
						con.println("");
						con.println(" Too many invalid attempts. Game will now exit.");
						con.sleep(500);
						con.closeWindow();
						
					}
				}
			}
		}
	}// end of method
	
	
	public static void highScores(Console con){
		TextInputFile txtHighScore = new TextInputFile("highscore.txt"); 
		int intNum = 0;
		while(txtHighScore.eof() == false){
			txtHighScore.readLine();
			txtHighScore.readLine();
			intNum++;
		}
		txtHighScore.close();
		
		String strHighScore[][];
		strHighScore = new String[intNum][2];
		int intCount = 0;
		
		// reopen high score txt file & store values into strHighScore array
		txtHighScore = new TextInputFile("highscore.txt"); 
		while(txtHighScore.eof() == false){
			strHighScore[intCount][0] = txtHighScore.readLine();
			System.out.println(strHighScore[intCount][0]);
			strHighScore[intCount][1] = txtHighScore.readLine();
			System.out.println(strHighScore[intCount][1]);
			intCount++;
		}
		txtHighScore.close();
		
		// bubble sort words
		int intRow1;
		int intRow2;
		String strTempNum;
		String strTempName;
		for(intRow1 = 0; intRow1 < intNum - 1; intRow1++){
			for(intRow2 = 0; intRow2 < intNum - intRow1 - 1; intRow2++){
				if(Integer.parseInt(strHighScore[intRow2][1]) < Integer.parseInt(strHighScore[intRow2+1][1])){
					// store values greater into a temporary variable
					strTempName = strHighScore[intRow2][0];
					strTempNum = strHighScore[intRow2][1];
					
					// right item moves to the left
					strHighScore[intRow2][0] = strHighScore[intRow2+1][0];
					strHighScore[intRow2][1] = strHighScore[intRow2+1][1];
					
					// put temporary value to right
					strHighScore[intRow2+1][0] = strTempName;
					strHighScore[intRow2+1][1] = strTempNum;
				}
			}
		}
		
		// print to debug (ensure bubble sort works)
		System.out.println(" ");
		System.out.println("Bubble Sort");
		for(intCount = 0; intCount < intNum; intCount++){
			System.out.println(strHighScore[intCount][1]+" | "+strHighScore[intCount][0]);
		}
		
		con.println("Leaderboard");
		con.println("Username | Score");
		for(intCount = 0; intCount < intNum; intCount++){
			con.println(strHighScore[intCount][1]+" | "+strHighScore[intCount][0]);
		}
	}// end of method
	
	
	
}
