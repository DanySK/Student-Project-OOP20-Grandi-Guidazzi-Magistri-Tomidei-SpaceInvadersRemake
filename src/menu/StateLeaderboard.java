package menu;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import menu.factories.LeaderboardFactory;
import menu.factories.PanelFactory;
import menu.factories.TitleFactory;
import util.Constants;
import util.Strings;

/**
 *	A class that contains all the object to create the StateLeaderboard
 */
public class StateLeaderboard implements State{

	private JPanel panel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private TitleFactory titleFactory = new TitleFactory();
	private PanelFactory panelFactory = new PanelFactory();
	private LeaderboardFactory leaderboardFactory = new LeaderboardFactory();
	private List<String> leaderboardList = this.leaderboardFactory.getLeaderboardList();
	
	/**
	 * The constructor of the StateLeaderboard,
	 * this state is showed when the button Leaderboard is pressed.
	 * @param board
	 */
	public StateLeaderboard(Board board) {
		this.panel = this.panelFactory.createPanel(Strings.LEADERBOARD, board);
		this.centerPanel.setOpaque(false);
		this.centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		this.panel.add(this.centerPanel, BorderLayout.CENTER);
		
		for(int i=Constants.minPodium; i<=Constants.maxPodium; i++) {
			this.centerPanel.add(this.titleFactory.createTitle(i + ") " + this.leaderboardList.get(i-1), Constants.subtitleSize, Constants.colorSubtitle));
		}
	}
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}

}
