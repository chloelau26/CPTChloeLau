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
			
			// print to debug
			System.out.println("Word added: " + strWords[intRow][0]);
			System.out.println(intRow+ "  "+strWords[intRow][1]);
		}		
		list.close();
		
		// continue
		/*
		int intRandom;
		for(intCount = 0; intCount < intNum; intCount++){
			intRandom = (int)(Math.random()*100+1);
			strWords[intCount][1] = Integer.toString(intRandom);
			// print to debug (ensure a
			System.out.println(intCount+ "  "+strWords[intCount][1]);
		}
		*/
		
		/*
		int intRandom;
		boolean blnDiffNum = false;
		int intSecond;
		int intWordNum;
		for(intRow = 0; intRow < intNum; intRow++){
			intRandom = (int) (Math. random()*100 + 1);
			while(!blnDiffNum){
				for(intSecond = 0; intSecond < intNum; intSecond++){
					intWordNum = Integer.parseInt(strWords[intSecond][1]);
					if(intWordNum == intRandom){
						intRandom = (int) (Math. random()*100 + 1);
					}
				}
			}
		}
		*/
		// intRandom = (int) (Math. random()*intRange + intStart);
		
		
	}
	
	
}
