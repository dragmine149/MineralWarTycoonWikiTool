package main;

import java.util.Calendar;
import java.text.DateFormatSymbols;

public class CodeConvert {

	public static String Month() {
		Calendar now = Calendar.getInstance();
		int imonth = now.get(Calendar.MONTH);
		int Week = now.get(Calendar.WEEK_OF_MONTH);
		String Month = new DateFormatSymbols().getMonths()[imonth];
		int Year = now.get(Calendar.YEAR);
		return Month + " " + Year + " " + Week + ordinalNo(Week) + " week";
	}
	
	// Got off the internet, Converts a value into a string with the correct format (21st, etc..)
	public static String ordinalNo(int value) {
		int hunRem = value % 100;
		int tenRem = value % 10;
		if (hunRem - tenRem == 10) {
			return "th";
		}
		switch (tenRem) {
		case 1:
			return "st";
		case 2:
			return "nd";
		case 3:
			return "rd";
		default:
			return "th";
		}
	}
	
	public static String Convert(String Username, int Pos, String New, String Current) {
		String Char;
		switch (Pos) {
		case 1:
			Char = "🟧";
			break;
		case 2:
			Char = "⬜️";
			break;
		case 3:
			Char = "🟫";
			break;
		default:
			Char = "";
			break;
		}
		
		String Data = "|-\n|"
		+ Char + Pos + ordinalNo(Pos) + "\n"
		+ "|" + Username + "\n"
		+ "|" + Current + "\n"
		+ "|" + New + "\n";
		
		return Data;
	}
	
	public static String TableConvert(String Info, int table) {
		
		// sort out the top of the table
		String Start = "{| class=\"article-table\"\n"
				+ Month() + "\n"
				+ "!Position \n"
				+ "!Username \n";
		
		//case 2,3 are to come
		switch (table) {
		case 0:
			Start = Start + "!Rebirths\n!Rebirths since last week";
			break;
		case 1:
			Start = Start + "!kills\n!Killstreak improvement this week";
			break;
		}
		
		Start = Start + "\n" + Info + "|}";
		
		return Start;
	}
	
}
