package predictive.gui.panel;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InputPanel extends JPanel {

	protected JTextArea textarea;
	
	public InputPanel() {
		// TODO Auto-generated constructor stub
		textarea = new JTextArea(5, 80);
		textarea.setEditable(false);
		add(textarea);
	}

}
