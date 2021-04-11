package menu;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import menu.factories.PanelFactory;
import menu.factories.TitleFactory;
import util.Constants;
import util.Strings;

/**
 *	A class that contains all the object to create the StateAudioSettings
 */
public class StateAudioSettings implements State{

	private JPanel panel;
	private JPanel centerPanel = new JPanel();
	private PanelFactory panelFactory = new PanelFactory();
	private TitleFactory titleFactory = new TitleFactory();
	
	/**
	 * The constructor of the StateAudioSettings,
	 * this state is showed when the button Audio settings is pressed.
	 * @param board
	 */
	public StateAudioSettings(Board board) {
		
		this.panel = this.panelFactory.createPanel(Strings.AUDIO_SETTINGS, board);
		this.panel.add(this.centerPanel, BorderLayout.CENTER);
		
		this.centerPanel.setLayout(new BorderLayout());
		this.centerPanel.setOpaque(false);
		this.centerPanel.add(this.titleFactory.createTitle("COMING SOON...", Constants.titleSize, Constants.colorSubtitle), BorderLayout.CENTER);
		
		
	}
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}

}
