import arc.*;

public class testing2{
	public static void main(String[] args){
		Console con = new Console();
		cptTools.storeWords(con);
		
		/*
		TextInputFile list = new TextInputFile("Formula 1.txt");
		
		int intNum = 25;
		
		String strWords[][];
		strWords = new String[intNum][2];
		
		int intCount;
		
		for(intCount = 0; intCount < intNum; intCount++){
			strWords[intCount][0] = list.readLine();
		}
		list.close();
		
		for(intCount = 0; intCount < intNum; intCount++){
			strWords[intCount][1] = "0";
		}
		
		/*
		int intValue;
		int intSecond;
		int intRandom;
		boolean blnDiffNum = false;
		while(!blnDiffNum){
			for(intCount = 0; intCount < intNum; intCount++){
				intValue = Integer.parseInt(strWords[intCount][1]);
				intRandom = (int) (Math. random()*100 + 1);
				if(intValue != intRandom){
					intSecond = intCount++;
				}
			}
		}
		*/
		/*
		int intRandom;
		for(intCount = 0; intCount < intNum; intCount++){
			intRandom = (int)(Math.random()*100+1);
			strWords[intCount][1] = Integer.toString(intRandom);
			// con.println(strWords[intCount][1]);
			System.out.println(intCount+ "  "+strWords[intCount][1]);
		}
		*/
		
		/*
		intCount = 0;
		boolean blnDiffNum;
		boolean blnContinue = true;
		while(intCount <= intNum - 2 && blnContinue){
			if(strWords[intCount][1].equals(strWords[intCount + 1][1])){
				blnDiffNum = false;
				while(!blnDiffNum){
				intRandom = (int)(Math.random()*100+1);
				strWords[intCount + 1][1] = Integer.toString(intRandom);
					if(!strWords[intCount][1].equals(strWords[intCount + 1][1])){
						blnDiffNum = true;
					}
				}
			}
			intCount++;
		}
		*/
	
		/*
		int intRow;
		intCount = 0;
		boolean blnDiffNum;
		boolean blnContinue = true;
		while(intCount <= intNum - 2 && blnContinue){
			for(int
			if(strWords[intCount][1].equals(strWords[intCount + 1][1])){
				blnDiffNum = false;
				while(!blnDiffNum){
				intRandom = (int)(Math.random()*100+1);
				strWords[intCount + 1][1] = Integer.toString(intRandom);
					for(intRow = 0; intRow < intNum - 2; intRow++){
						if(!strWords[intRow][1].equals(strWords[intRow + 1][1])){
							blnDiffNum = true;
						}
					}
				}
			}
			intCount++;
		}
		*/
		
		/*
		// int intCount;
		int intRow;
		// int intRandom;
		int intSecond;
		int intThird;
		int intFourth;
		int intTrack = 0;
		boolean blnDiffNum;
		
		for(intCount = 0; intCount <= intNum - 2; intCount++){
			for(intRow = 1; intRow <= intNum - 1; intRow++){
				intTrack = 0;
				if(strWords[intCount][1].equals(strWords[intRow][1])){
					blnDiffNum = false;
					while(!blnDiffNum){
						intRandom = (int)(Math.random()*100+1);
						strWords[intCount][1] = Integer.toString(intRandom);
						for(intThird = 0; intThird <= intNum - 1; intThird++){
							if(!strWords[intCount][1].equals(strWords[intThird][1])){
								intTrack ++;
							}
						if(intTrack == intNum){
							blnDiffNum = true;
						}
						}
					}
				}
			}
		}
		*/
		
		
		/*
		int intRow;
		int intThird;
		int intTrack = 0;
		boolean blnDiffNum;

		for (intCount = 0; intCount <= intNum - 1; intCount++) {
			for (intRow = 0; intRow <= intNum - 1; intRow++) {
				// Compare only different indices
				if (intRow != intCount && strWords[intCount][1].equals(strWords[intRow][1])) {
					blnDiffNum = false;
					while (!blnDiffNum) {
						intRandom = (int) (Math.random() * 100 + 1);
						strWords[intCount][1] = Integer.toString(intRandom);

						// Reset intTrack and check uniqueness
						intTrack = 0;
						for (intThird = 0; intThird <= intNum - 1; intThird++) {
							if (intThird != intCount && !strWords[intCount][1].equals(strWords[intThird][1])) {
								intTrack++;
							}
						}

						// If all elements are unique, exit the loop
						if (intTrack == intNum - 1) {
							blnDiffNum = true;
						}
					}
				}
			}
		}
		
		
		
		for(intCount = 0; intCount < intNum; intCount++){
			System.out.println(intCount+ "  "+strWords[intCount][1]);
		}
		
		
		*/
	}
}
