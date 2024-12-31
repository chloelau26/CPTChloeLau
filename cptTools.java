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
	
}
