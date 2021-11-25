package predictive.gui.panel;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InputPanel extends JPanel {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -335052415787783429L;
	protected JTextArea textarea;
	
	public InputPanel() {
		// TODO Auto-generated constructor stub
		textarea = new JTextArea(5, 80);
		textarea.setEditable(false);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		add(textarea);
	}
	
	public void setText(String text) {
		textarea.setText(text);
		System.out.println(text);
	}

}
