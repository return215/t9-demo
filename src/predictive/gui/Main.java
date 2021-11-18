package predictive.gui;

import javax.swing.*;

import predictive.gui.panel.KeypadPanel;

import java.awt.*;

public class Main {

	public static void main(String[] args) {
		try {
			// Use native theme if possible.
			// Falls back to standard Swing theme.
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
			System.exit(1);
		}
		

	    KeypadPanel kp = new KeypadPanel();
	 
	    /** content pane */
	    JPanel cp = new JPanel();
	    cp.add(kp);
	 
	    JFrame frame = new JFrame();
	    frame.setTitle("Predictive Text Demo");
	    frame.setPreferredSize(new Dimension(320, 480));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setContentPane(cp);
	    frame.pack();
	    frame.setVisible(true);
	 
	  
	}

}
