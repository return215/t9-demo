package predictive.gui.panel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import predictive.gui.util.HTMLString;

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
	JButton button1 = new JButton(HTMLString.createKeypadFormat("1",".,-!"));
	/** Button 2 for ABC */
	JButton button2 = new JButton(HTMLString.createKeypadFormat("2","ABC"));
	/** Button 3 for DEF */
	JButton button3 = new JButton(HTMLString.createKeypadFormat("3","DEF"));
	/** Button 4 for GHI */
	JButton button4 = new JButton(HTMLString.createKeypadFormat("4","GHI"));
	/** Button 5 for JKL */
	JButton button5 = new JButton(HTMLString.createKeypadFormat("5","JKL"));
	/** Button 6 for MNO */
	JButton button6 = new JButton(HTMLString.createKeypadFormat("6","MNO"));
	/** Button 7 for PQRS */
	JButton button7 = new JButton(HTMLString.createKeypadFormat("7","PRQS"));
	/** Button 8 for TUV */
	JButton button8 = new JButton(HTMLString.createKeypadFormat("8","TUV"));
	/** Button 9 for WXYZ */
	JButton button9 = new JButton(HTMLString.createKeypadFormat("9","WXYZ"));
	/** Button * for next prediction */
	JButton buttonA = new JButton(HTMLString.createKeypadFormat("*","(NEXT)"));
	/** Button 0 for space */
	JButton button0 = new JButton(HTMLString.createKeypadFormat("0","_"));
	/** Button # for backspace */
	JButton buttonE = new JButton(HTMLString.createKeypadFormat("#","(DEL)"));
	
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
	
	public void addActionListener(ActionListener l) {
		// TODO Auto-generated method stub
		button1.addActionListener(l);
		button2.addActionListener(l);
		button3.addActionListener(l);
		button4.addActionListener(l);
		button5.addActionListener(l);
		button6.addActionListener(l);
		button7.addActionListener(l);
		button8.addActionListener(l);
		button9.addActionListener(l);
		buttonA.addActionListener(l);
		button0.addActionListener(l);
		buttonE.addActionListener(l);
	}

}
