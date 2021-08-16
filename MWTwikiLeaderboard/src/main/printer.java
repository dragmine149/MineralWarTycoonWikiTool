package main;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class printer extends TimerTask {
	static JLabel CopyInfo;
	static String Text;
	static Timer timer;
	
	
	public static void Inputs(JLabel CI, String T, Timer TT) { // inputs (because it doesn't like going straight into run function)
		CopyInfo = CI;
		Text = T;
		timer = TT;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		CopyInfo.setText(Text); // set 
		System.out.println("Sset");
		timer.cancel(); // cancel (so we don't have multiple and/or inf loops)
	}
	
}

