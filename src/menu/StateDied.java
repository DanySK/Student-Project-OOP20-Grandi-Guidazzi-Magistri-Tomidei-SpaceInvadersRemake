package menu;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import menu.factories.LabelFactory;
import menu.factories.PanelBackgroundFactory;
import util.Strings;

public class StateDied implements State{

	private PanelBackgroundFactory panel = new PanelBackgroundFactory(Strings.PANEL_BACKGROUND);
	private LabelFactory labelFactory = new LabelFactory();
	
	public StateDied(Board board) {
		this.panel.setLayout(new BorderLayout());
		this.panel.add(this.labelFactory.createButton(Strings.GO_BACK_TO_MENU, board, "Center"), BorderLayout.SOUTH);
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}

}
