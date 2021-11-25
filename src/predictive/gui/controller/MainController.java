package predictive.gui.controller;


import predictive.gui.model.InputModel;
import predictive.gui.view.MainView;

public class MainController {
	private InputModel model;
	private MainView view;
	
	public MainController(InputModel m, MainView v) {
		// TODO Auto-generated constructor stub
		model = m;
		view = v;
	}
	
	public void showView() {
		view.show();
	}
	
	public void hideView() {
		view.hide();
	}
}
