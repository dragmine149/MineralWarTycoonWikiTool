package main;

import java.util.Arrays;

public class OptionCalc {
	
	public static int Input(String s) {
		String[] split = s.split(" ");
		
		 // this means, that it doesn't have to be in a certain place to work.
		System.out.println(Arrays.asList(split).contains("killstreak"));
		System.out.println(Arrays.asList(split).contains("rebirth"));
		if (Arrays.asList(split).contains("killstreak")) {
			return 1;
		}
		else if (Arrays.asList(split).contains("rebirth")) {
			return 0;
		}
		
		return -1; // should never happen, but needed so.
	}
}


