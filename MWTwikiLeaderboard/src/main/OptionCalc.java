package main;

public class OptionCalc {
	
	public static int Input(String s) {
		String[] split = s.split(" ");
		
		if (split[0].contains("rebirth")) {
			return 0;
		}
		
		return 1;
	}
	
}
