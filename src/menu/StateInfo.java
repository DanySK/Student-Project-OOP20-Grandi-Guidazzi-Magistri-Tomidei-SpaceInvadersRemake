package menu;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import menu.factories.LabelFactory;
import menu.factories.PanelBackgroundFactory;
import menu.factories.TitleFactory;
import util.Constants;
import util.Strings;

public class StateInfo implements State{

	private TitleFactory titleFactory = new TitleFactory();
	private LabelFactory labelFactory = new LabelFactory();
	private JPanel panel = new PanelBackgroundFactory(Strings.PANEL_BACKGROUND);
	private JPanel centerPanel = new JPanel();
	
	public StateInfo(Board board) {
		this.panel.setOpaque(false);
		this.panel.setLayout(new BorderLayout());
		this.panel.add(this.centerPanel, BorderLayout.CENTER);
		this.centerPanel.setLayout(new BorderLayout());
		this.centerPanel.setOpaque(false);
		
		this.panel.add(this.titleFactory.createTitle("How to play", Constants.titleSize, Constants.colorTitle), BorderLayout.NORTH);
		
		this.centerPanel.add(this.titleFactory.createTitle("Use the Right and Left arrows for "
				+ "move your player and Space Bar for shoot!", Constants.subtitleSize, Constants.colorSubtitle), BorderLayout.NORTH);
		
		this.centerPanel.add(this.labelFactory.createButton(Strings.START_GAME, board, "Center"));
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}

	
}
