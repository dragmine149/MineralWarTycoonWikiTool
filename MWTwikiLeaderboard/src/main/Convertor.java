package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import javax.swing.JLabel;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;


/**
 * 
 * This class makes the ui and calls other classes
 * 
 * @author dan
 *
 */
public class Convertor {

	private JFrame frmLeaderboardConvertor;
	private Boolean Dark = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Convertor window = new Convertor();
					window.frmLeaderboardConvertor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Convertor() {
		initialize();
	}	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// frame
		frmLeaderboardConvertor = new JFrame();
		frmLeaderboardConvertor.getContentPane().setBackground(Color.DARK_GRAY);
		frmLeaderboardConvertor.getContentPane().setForeground(Color.DARK_GRAY);
		frmLeaderboardConvertor.setBackground(Color.GRAY);
		frmLeaderboardConvertor.setResizable(false);
		frmLeaderboardConvertor.setTitle("Leaderboard Convertor");
		frmLeaderboardConvertor.setBounds(100, 100, 800, 300);
		frmLeaderboardConvertor.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmLeaderboardConvertor.getContentPane().setLayout(null);
		
		// Copy button
		JButton Copy = new JButton("Copy");
		Copy.setBounds(327, -2, 117, 29);
		frmLeaderboardConvertor.getContentPane().add(Copy);
		
		// Data input
		JEditorPane Input = new JEditorPane();
		Input.setBackground(Color.LIGHT_GRAY);
		Input.setToolTipText("Input Data Here.");
		Input.setBounds(0, 0, 332, 106);
		frmLeaderboardConvertor.getContentPane().add(Input);
		
		TextArea UpdateLog = new TextArea();
		UpdateLog.setBackground(Color.LIGHT_GRAY);
		UpdateLog.setText("INFORMATION:\nThis application was made by dragmine149 for use when\nconverting a leaderboard file made by Jamedius2018\n\nHOW TO USE:\nGet the recent week rebirth file from either #killstreak or #rebirth\nand paste it in the box above this box\nClick the copy button and you have your table,\nThen go over to the wiki edit source and past\nthe new table over the old table.");
		UpdateLog.setEditable(false);
		UpdateLog.setBounds(450, 0, 350, 262);
		UpdateLog.setText("UPDATE LOG:\n"
				+ "Update 3:\n"
				+ "- DARK MODE, and a button to switch from dark to light if wanted.\n"
				+ "- Information, when you click 'copy' it will tell you if it was\n"
				+ "  sucesffuly or failed. \n"
				+ "\n\n"
				+ "Update 2.1:\n"
				+ "- Default dark mode, no button to switch yet.\n"
				+ "\n\n"
				+ "Update 2:\n"
				+ "- rewrote generation of leaderboard table\n"
				+ "- Using date time instead of splitting it from the input\n"
				+ "- Works with kill streak\n"
				+ "- Should work with other leaderboard type when they come out\n"
				+ "- Update log (this)\n"
				+ "\n\n"
				+ "(Bug) Update 1:\n"
				+ "- Updated to work with week names (1st, 2nd, 3rd etc...)\n"
				+ "\n\n"
				+ "RELEASE:\n"
				+ "- From voting here it is!\n"
				+ "- Works with rebirth and kill streak\n"
				+ "- Easy to use ui\n"
				+ "- Description!");
		
		frmLeaderboardConvertor.getContentPane().add(UpdateLog);
		
		// Information (about the app, etc...)
		TextArea Information = new TextArea();
		Information.setBackground(Color.LIGHT_GRAY);
		Information.setEditable(false);
		Information.setText("INFORMATION:\n"
				+ "This application was made by dragmine149 for use when\n" 
				+ "converting a leaderboard file made by Jamedius2018\n\n"
				+ "NOTES:\n"
				+ "- When copying to the wiki, you might see a line gap between each line.\n"
				+ "Do not worry about this as this doesn't change the visual effect\n"
				+ "- If you find any bugs, please ping me (dragmine149#5048) on discord\n"
				+ "with the bug, I would also like a screenshot but is not needed.\n\n"
				+ "HOW TO USE:\n"
				+ "Get the recent week rebirth file from either #killstreak or #rebirth\n"
				+ "and paste it in the box above this box\n"
				+ "Click the copy button and you have your table,\n" 
				+ "Then go over to the wiki edit source and past\n"
				+ "the new table over the old table.");
		Information.setBounds(0, 112, 444, 160);
		frmLeaderboardConvertor.getContentPane().add(Information);
		
		JButton DarkMods = new JButton("LightMode");
		DarkMods.setBounds(327, 59, 117, 29);
		frmLeaderboardConvertor.getContentPane().add(DarkMods);
		
		JLabel CopyInfo = new JLabel("Ready for use");
		CopyInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		CopyInfo.setForeground(Color.WHITE);
		CopyInfo.setBackground(Color.LIGHT_GRAY);
		CopyInfo.setBounds(337, 27, 100, 34);
		frmLeaderboardConvertor.getContentPane().add(CopyInfo);
		DarkMods.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Dark = !Dark;
				if (!Dark) {
					DarkMods.setText("DarkMode");
					Information.setBackground(Color.WHITE);
					UpdateLog.setBackground(Color.WHITE);
					frmLeaderboardConvertor.getContentPane().setBackground(Color.WHITE);
					CopyInfo.setBackground(Color.WHITE);
					CopyInfo.setForeground(Color.BLACK);
				} else {
					DarkMods.setText("LightMode");
					Information.setBackground(Color.LIGHT_GRAY);
					UpdateLog.setBackground(Color.LIGHT_GRAY);
					frmLeaderboardConvertor.getContentPane().setBackground(Color.DARK_GRAY);
					CopyInfo.setBackground(Color.LIGHT_GRAY);
					CopyInfo.setForeground(Color.WHITE);
				}
			}
		});
		
		// copy clicked 
		Copy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					System.out.print("Coppying...\n"); // print
					
					String Text = Input.getText().toString(); // set (later)
					String Output = "Error in generating data."; // set
					
					Output = Create.Info(Text, OptionCalc.Input(Text)); // get the output
					
					if (Output == "Error in generating data.") { // check IF output
						System.out.print(Output + "\n\n"); // print
						CopyInfo.setText(Output);
					} else {
						KeyboardCopy.Copy(Output); // else copy
						CopyInfo.setText("Coppied!");
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					CopyInfo.setText("Error whilst running.");
					
				} finally {
					Timer timer = new Timer();
					TimerTask task = new printer();
					
					printer.Inputs(CopyInfo, "Ready to use", timer);
					timer.schedule(task, 5000);
				}
			}
			
		});
	}
}
