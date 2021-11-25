package predictive.gui.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import predictive.dictionary.DictionaryBase;
import predictive.dictionary.DictionaryList;
import predictive.gui.model.InputModel;
import predictive.gui.panel.InputPanel;
import predictive.gui.panel.KeypadPanel;
import predictive.gui.util.HTMLString;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

@SuppressWarnings("deprecation")
public class MainView implements Observer, ActionListener, KeyListener {

	private KeypadPanel kp = new KeypadPanel();
	private InputPanel ip = new InputPanel();
	
	private InputModel im;
	
	private DictionaryBase dict;
	
	private JPanel cp = new JPanel(new BorderLayout(8, 8));

	private JFrame frame;
	
	public MainView() {
		frame = new JFrame();
		frame.setTitle("Predictive Text Demo");
		frame.setPreferredSize(new Dimension(320, 480));
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setContentPane(cp);
    	frame.pack();
    	
		try {
			dict = new DictionaryList("words");
			im = new InputModel(dict);
			im.addObserver(this);
			kp.addActionListener(this);
			cp.add(ip, BorderLayout.PAGE_START);
			cp.add(kp, BorderLayout.PAGE_END);
			cp.addKeyListener(this);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Unable to read dictionary file. Please check if the file exists and can be accessed.");
			JOptionPane.showMessageDialog(frame, 
					"Unable to read dictionary file. \nPlease check if the file exists and can be accessed.",
					frame.getTitle(),
					JOptionPane.ERROR_MESSAGE
					);
			System.exit(1);
		}
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	public void hide() {
		frame.setVisible(false);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof InputModel) {
			ip.setText(arg.toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		
		switch (s) {
		case "1":
			im.addOneChar('1');
			break;
		case "2":
			im.addOneChar('2');
			break;
		case "3":
			im.addOneChar('3');
			break;
		case "4":
			im.addOneChar('4');
			break;
		case "5":
			im.addOneChar('5');
			break;
		case "6":
			im.addOneChar('6');
			break;
		case "7":
			im.addOneChar('7');
			break;
		case "8":
			im.addOneChar('8');
			break;
		case "9":
			im.addOneChar('9');
			break;
		case "0":
			im.nextWord();
			break;
		case "next":
			im.cycleCurrentWord();
			break;
		case "del":
			im.removeOneChar();
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
