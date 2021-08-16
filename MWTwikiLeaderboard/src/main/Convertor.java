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
import javax.swing.JMenuBar;
import java.awt.Font;

import javax.swing.JLabel;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * This class makes the ui and calls other classes
 *
 * @author dan
 *
 */
public class Convertor {

	private JFrame frmLeaderboardConvertor;

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
	 * Initialise the contents of the frame.
	 */

	private boolean Dark = true;
	private boolean Info = false;

	private void initialize() {
		// frame
		frmLeaderboardConvertor = new JFrame();
		frmLeaderboardConvertor.setFont(new Font("Roboto Slab", Font.PLAIN, 12));
		frmLeaderboardConvertor.setForeground(Color.BLACK);
		frmLeaderboardConvertor.getContentPane().setBackground(Color.DARK_GRAY);
		frmLeaderboardConvertor.getContentPane().setForeground(Color.DARK_GRAY);
		frmLeaderboardConvertor.setBackground(Color.BLACK);
		frmLeaderboardConvertor.setResizable(false);
		frmLeaderboardConvertor.setTitle("Leaderboard Convertor");
		frmLeaderboardConvertor.setBounds(100, 100, 800, 300);
		frmLeaderboardConvertor.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmLeaderboardConvertor.getContentPane().setLayout(null);

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
		UpdateLog.setBounds(338, 0, 462, 262);
		UpdateLog.setText("UPDATE LOG:\n"
				+ "Update 3:\n"
				+ "- DARK MODE, and a button to switch from dark to light if wanted.\n"
				+ "- Information, when you click 'copy' it will tell you if it was\n"
				+ "  sucesffuly or failed. \n"
				+ "- Fixed a bug causing rebirths leaderboard to get both values\n"
				+ "(killstreak and rebirth)\n"
				+ "- Changed how getting the leaderboard name works.\n"
				+ "(Better for future)\n"
				+ "- Fixed an issue with the month name sometimes being incorrect\n"
				+ "- UI Update, NOTE: Menu bar might not go into dark mode. (don't know why)\n"
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
				+ "This application was made by dragmine149 and Guy_732 for use when\n"
				+ "converting a leaderboard file made by Jamedius2018\n\n"
				+ "NOTES:\n"
				+ "- When copying to the wiki, you might see a line gap between each line.\n"
				+ "Do not worry about this as this doesn't change the visual effect\n"
				+ "- If you find any bugs, please open an issue with the link below\n"
				+ "https://github.com/dragmine149/MineralWarTycoonWikiTool/issues/new\n\n"
				+ "HOW TO USE:\n"
				+ "Get the recent week rebirth file from either #killstreak or #rebirth\n"
				+ "and paste it in the box above this box\n"
				+ "Click the copy button and you have your table,\n"
				+ "Then go over to the wiki edit source and past\n"
				+ "the new table over the old table.");
		Information.setBounds(338, 0, 462, 262);
		frmLeaderboardConvertor.getContentPane().add(Information);
		
		JLabel CopyInfo = new JLabel("Ready for use");
		CopyInfo.setBounds(0, 117, 332, 30);
		frmLeaderboardConvertor.getContentPane().add(CopyInfo);
		CopyInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		CopyInfo.setForeground(Color.WHITE);
		CopyInfo.setBackground(Color.LIGHT_GRAY);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.GRAY);
		menuBar.setForeground(Color.BLACK);
		frmLeaderboardConvertor.setJMenuBar(menuBar);

		// Copy button
		JButton Copy = new JButton("Copy");
		Copy.setForeground(Color.BLACK);
		Copy.setBackground(Color.WHITE);
		menuBar.add(Copy);

		JButton DarkMods = new JButton("LightMode");
		DarkMods.setBounds(327, 59, 117, 29);

		menuBar.add(DarkMods);

		JButton UInfo = new JButton("Information");
		menuBar.add(UInfo);

		UInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Info = !Info;
				if (Info) {
					UInfo.setText("UpdateLog");
					Information.setVisible(true);
					UpdateLog.setVisible(false);
				} else {
					UInfo.setText("Information");
					UpdateLog.setVisible(true);
					Information.setVisible(false);
				}
			}

		});

		DarkMods.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Dark = !Dark;
				if (!Dark) {
					DarkMods.setText("DarkMode");
					Information.setBackground(Color.WHITE);
					UpdateLog.setBackground(Color.WHITE);
					frmLeaderboardConvertor.getContentPane().setBackground(Color.WHITE);
					menuBar.setBackground(Color.WHITE);
					CopyInfo.setForeground(Color.BLACK);
				} else {
					DarkMods.setText("LightMode");
					Information.setBackground(Color.LIGHT_GRAY);
					UpdateLog.setBackground(Color.LIGHT_GRAY);
					frmLeaderboardConvertor.getContentPane().setBackground(Color.DARK_GRAY);
					menuBar.setBackground(Color.LIGHT_GRAY);
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

					int O = OptionCalc.Input(Text);
					if (O == -1) {
						throw new Exception("Error in getting leaderboard value");
					}

					Output = Create.Info(Text, O); // get the output

					if (Output == "Error in generating data.") { // check IF output
						System.out.println(Output + "\n"); // print
						CopyInfo.setText(Output);
					} else {
						KeyboardCopy.Copy(Output); // else copy
						CopyInfo.setText("Coppied!");
					}
				}
				catch (Exception e)
				{
					CopyInfo.setText("Error whilst running.");
					e.printStackTrace();

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
