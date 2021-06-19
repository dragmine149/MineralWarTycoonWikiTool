package main;
/**
 * This class copies the output and pastes it into your keyboard so you can ctrl/cmd + v to paste it
 * *
 * @author dragmine149 
 *
 */

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class KeyboardCopy {

	public static void Copy(String copy) {
		System.out.print(copy + "\n");
		StringSelection stringSelection = new StringSelection(copy);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
	
}
