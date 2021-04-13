package menu.factories;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import menu.Board;
import util.Constants;
import util.Strings;
/**
 * A simple JPanel factory to avoid repetitions.
 */
public class PanelFactory{
	
	private TitleFactory titleFactory = new TitleFactory();
	private LabelFactory labelFactory = new LabelFactory();
	
	JPanel panel = new JPanel();
	
	/**
	 * Create a new JPanel with a button inside in a standard position.
	 * 
	 * @param title
	 * @param board
	 * @return the panel created
	 */
	public JPanel createPanel(String title, Board board) {
		
		this.panel.setLayout(new BorderLayout());
		this.panel.setOpaque(false);
		this.panel.add(this.titleFactory.createTitle(title, Constants.titleSize, Constants.colorTitle), BorderLayout.NORTH);
		this.panel.add(this.labelFactory.createButton(Strings.GO_BACK_TO_MENU, board, "Left"), BorderLayout.SOUTH);
		
		return this.panel;
	}
	
}
