package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import menu.factories.PanelFactory;
import menu.factories.SliderFactory;
import menu.factories.TitleFactory;
import util.Constants;
import util.Strings;

/**
 *	A class that contains all the objects to create the StateAudioSettings
 */
public class StateAudioSettings implements State{

	private JPanel panel;
	private JPanel centerPanel = new JPanel();
	private PanelFactory panelFactory = new PanelFactory();
	private TitleFactory titleFactory = new TitleFactory();
	private SliderFactory sliderFactory = new SliderFactory();
	
	/**
	 * The constructor of the StateAudioSettings,
	 * this state is showed when the button Audio settings is pressed.
	 * @param board
	 */
	public StateAudioSettings(Board board) {
		
		this.panel = this.panelFactory.createPanel(Strings.AUDIO_SETTINGS, board);
		this.panel.add(this.centerPanel, BorderLayout.CENTER);
	
		this.centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		this.centerPanel.setOpaque(false);
		this.centerPanel.add(this.titleFactory.createTitle("Choose an audio intensity:", Constants.subtitleSize, Constants.colorSubtitle), BorderLayout.CENTER);
		
		this.centerPanel.add(this.sliderFactory.create(board));
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}

}
