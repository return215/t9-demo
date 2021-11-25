package predictive.gui;

import javax.swing.*;

import predictive.gui.controller.MainController;
import predictive.gui.model.InputModel;
import predictive.gui.panel.InputPanel;
import predictive.gui.panel.KeypadPanel;
import predictive.gui.view.MainView;

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
		

		MainView view = new MainView();
		MainController control = new MainController(null, view);
	
		control.showView();
	
	}

}
