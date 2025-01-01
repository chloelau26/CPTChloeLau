import arc.*;

public class cptChloeLau{
	public static void main(String[] args){
		Console con = new Console("Guess The Word", 1280, 720);
		
		// activate main menu 
		char chrChoice = cptTools.menu(con);
		boolean blnAvaliable = false;
		
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
				con.print("Enter username: ");
				strUser = con.readLine();
				
				// store into text file
				highScore.println(strUser);
				highScore.close();
				
				cptTools.storeWords(con);
								
			}else if(chrChoice == 'v'){
				// view high score option
				blnAvaliable = true;
				con.clear();
				con.println("a");
				
			}else if(chrChoice == 'q'){
				// quit option
				blnAvaliable = true;
				con.clear();
				con.println("s");
				
			}else if(chrChoice == 'h'){
				// help option
				blnAvaliable = true;
				con.clear();
				con.println("i");
				
			}else{
				con.sleep(100);
				con.clear();
				con.println("Invalid Input");
				con.println("Please Try Again");
				con.println("-----------------------------------------------");
				chrChoice = cptTools.menu(con);
			}
		}
		
		
		// start here
		
	}
}
