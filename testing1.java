import arc.*;

public class testing1{
}

import arc.*;

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
				TextOutputFile highScore = new TextOutputFile("High Score.txt",true); 
				
				// user input user info
				String strUser;
				con.print("Enter username: ");
				strUser = con.readLine();
				
				// store into text file
				highScore.println(strUser);
				highScore.close();
				
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
				
				
				
				
				// set up 2D array to input theme words into array
				String strWord[][];
				strWord = new String[intNum][2];
				
				int intRow; 
				for(intRow = 0; intRow < intNum; intRow++){
				String strLine = list.readLine();
					if(strLine != null){
						strWord[intRow][0] = list.readLine();
					}
					strWord[intRow][1] = "0";
					// print to debug
				// System.out.println("Word added: " + strWord[intRow][0]);
			
								
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

// assign random values to each word
		boolean blnValue = false;
		int intFirst;
		int intSecond = 0;
		for(intFirst = 0; intFirst < intNum; intFirst++){
			intRandom = (int) (Math. random()*intNum + 1);
			
			while(!blnValue){
				while(intSecond < intNum){
					int intArrayNum = Int.parseInt(strWord[intSecond][0]);
					if(intArrayNum != intRandom){
						intSecond++;
					}else if(intSecond == intNum - 1){
						if(intArrayNum != intRandom){
							blnValue = true;
						}
					}
				
				for(intCount = 0; intCount < intNum; intCount++){
					int intArrayNum = Int.parseInt(strWord[intRow][0]);
					if(intArrayNum != intRandom){
						
					}
					
				}
			}
		}
		
		

