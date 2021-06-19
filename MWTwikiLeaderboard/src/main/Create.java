/**
 * This class takes a leaderboard file and converts it into a wiki format file
 * *
 * @author dragmine149
 *  
 */
package main;

public class Create {
	
	public static String Info(String Data, int Input) {
		// For all leaderboard positions
		String Info = "";
		for (int i = 1; i <= 50 ; i++) {
			Info = Info + Calc(Data, i + CodeConvert.ordinalNo(i), i);
		}
		return CodeConvert.TableConvert(Info, Input);
	}
	
	private static String Calc(String Data, String Pos, int intPos) {
		
		String Username = "";
		String Current = "";
		String New = "";
		
		// Checks if first pos is not the title
		Data = Data.split(":")[1] + Data.split(":")[2];
		
		// Gets Username, Current, New of pos
		Username = Data.split(Pos)[1].split(" ")[1];
		Current = Data.split(Pos)[1].split(" ")[3];
		
		try {
			New = Data.split(Username)[2].split(" ")[2];
		} catch (ArrayIndexOutOfBoundsException e) {
			New = "0";
		}
		
		// Sort out part (code) for table
		return CodeConvert.Convert(Username, intPos, New, Current);
	}
	
}
