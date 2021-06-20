package menu;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import menu.factories.LabelFactory;
import menu.factories.PanelBackgroundFactory;
import menu.factories.TitleFactory;
import util.Constants;
import util.Strings;

/**
 *{@link State} that show info about how to play the game.
 */
public class StateInfo implements State{

	private TitleFactory titleFactory = new TitleFactory();
	private LabelFactory labelFactory = new LabelFactory();
	private JPanel panel = new PanelBackgroundFactory(Strings.PANEL_BACKGROUND);
	private JPanel centerPanel = new JPanel();
	private JTextArea textArea = new JTextArea();
	
	/**
	 * The constructor of state info that shows info
	 * and the button to start the game.
	 * @param board
	 */
	public StateInfo(Board board) {
		this.textArea.setText(Strings.INFO_TEXT);
		this.textArea.setFont(new Font("sans", Font.BOLD, 25));
		this.textArea.setLineWrap(true);
		this.textArea.setWrapStyleWord(true);
		this.textArea.setOpaque(false);
		this.textArea.setEnabled(false);
		this.panel.setOpaque(false);
		this.panel.setLayout(new BorderLayout());
		this.panel.add(this.centerPanel, BorderLayout.CENTER);
		this.centerPanel.setLayout(new BorderLayout());
		this.centerPanel.setOpaque(false);
		
		this.panel.add(this.titleFactory.createTitle("How to play", Constants.titleSize, Constants.colorTitle), BorderLayout.NORTH);
		
		this.centerPanel.add(this.textArea, BorderLayout.NORTH);
		this.centerPanel.add(this.labelFactory.createButton(Strings.START_GAME, board, "Center"));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}
}
