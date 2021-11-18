package predictive.gui.panel;

import java.awt.*;

import javax.swing.*;

public class KeypadPanel extends JPanel {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1674261373660374008L;

	/** 
	 * Keypad grid layout of 4 rows and 3 columns 
	 * with 4 unit gaps.
	 * */
	GridLayout _layout = new GridLayout(4,3,4,4);
	
	/** BUTTONS */
	/** Button 1 for symbols */
	JButton button1 = new JButton("1\n.,-!");
	/** Button 2 for ABC */
	JButton button2 = new JButton("2\nABC");
	/** Button 3 for DEF */
	JButton button3 = new JButton("3\nDEF");
	/** Button 4 for GHI */
	JButton button4 = new JButton("4\nGHI");
	/** Button 5 for JKL */
	JButton button5 = new JButton("5\nJKL");
	/** Button 6 for MNO */
	JButton button6 = new JButton("6\nMNO");
	/** Button 7 for PQRS */
	JButton button7 = new JButton("7\nPQRS");
	/** Button 8 for TUV */
	JButton button8 = new JButton("8\nTUV");
	/** Button 9 for WXYZ */
	JButton button9 = new JButton("9\nWXYZ");
	/** Button * for next prediction */
	JButton buttonA = new JButton("*\n(NEXT)");
	/** Button 0 for space */
	JButton button0 = new JButton("0\n_");
	/** Button # for backspace */
	JButton buttonE = new JButton("#\n(DEL)");
	
	public KeypadPanel() {
		setLayout(_layout);
		
		button1.setActionCommand("1");
		button2.setActionCommand("2");
		button3.setActionCommand("3");
		button4.setActionCommand("4");
		button5.setActionCommand("5");
		button6.setActionCommand("6");
		button7.setActionCommand("7");
		button8.setActionCommand("8");
		button9.setActionCommand("9");
		buttonA.setActionCommand("next");
		button0.setActionCommand("0");
		buttonE.setActionCommand("del");
		
		// add buttons in the correct order
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
		add(button9);
		add(buttonA);
		add(button0);
		add(buttonE);
	}

}
