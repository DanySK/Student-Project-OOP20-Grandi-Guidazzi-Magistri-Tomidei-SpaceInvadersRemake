package menu;


import java.awt.Color;

import javax.swing.BoxLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controller.GameControllerImpl;
import controller.GameViewController;
import menuController.menuController;
import menuController.menuControllerImpl;
import util.Constants;

/**
 * class that manages the change and creation of all the various states.
 */
public class Board {

	private JFrame frame = new JFrame();
	private State currentState;
	private menuController menuController = new menuControllerImpl(this); 
	private GameViewController controller;
	
	/**
	 * the constructor of the first state in the project, it contains all the frame characteristics.
	 */
	public Board() {
		this.controller = new GameControllerImpl();
		this.frame.setTitle("Space Invaders Remake");
		this.frame.setPreferredSize(Constants.preferDimension);
		this.frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.menuController.changeState(new StateMenu(this));
		this.frame.setVisible(true);
	}
	
	/**
	 * it take the new state in input and it shows the state on the frame repainting it and removing all the object of the last state.
	 * @param newState
	 */
	public void setCurrentState(State newState){
		this.frame.getContentPane().removeAll();
		this.currentState = newState;
		this.frame.getContentPane().add(currentState.getMainPanel());
		this.frame.getContentPane().setBackground(Color.black);
		this.currentState.getMainPanel().requestFocusInWindow();
		this.frame.pack();
	}
	
	/** a method to get the game view controller.
	 * 
	 * @return the GameViewController
	 */
	public GameViewController getController() {
		return this.controller;
	}
	
	/** a method to get the menu controller.
	 * 
	 * @return the menuController
	 */
	public menuController getMenuController() {
		return this.menuController;
	}
	/** a method to get the mainFrame.
	 * 
	 * @return the mainFrame
	 */
	public JFrame getFrame() {
		return this.frame;
	}
}
