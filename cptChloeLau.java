import arc.*;

public class cptChloeLau{
	public static void main(String[] args){
		Console con = new Console("Guess The Word", 1280, 720);
		
		// activate main menu 
		char chrChoice = cptTools.menu(con);
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
				
				// cptTools.play(con);
								
			}else if(chrChoice == 'v'){
				// view high score option
				blnAvaliable = true;
				con.clear();
				con.println("a");
				
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
				con.print(" Enter (p) to start game: ");
				chrChoice = con.readChar();
				
			}else{
				con.sleep(100);
				con.clear();
				con.println(" Invalid Input");
				con.println(" Please Try Again");
				con.println(" -----------------------------------------------");
				chrChoice = cptTools.menu(con); 
				
				if(chrChoice != 'p' && chrChoice != 'v' && chrChoice != 'q' && chrChoice != 'h'){
					con.clear();
					con.println("Invalid Input");
					con.println("Please Try Again");
					con.println("-----------------------------------------------");
					chrChoice = cptTools.menu(con); 
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
		
		
		// start here
		
	}
}
