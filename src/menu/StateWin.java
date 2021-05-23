package menu;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import menu.factories.LabelFactory;
import menu.factories.PanelBackgroundFactory;
import menu.factories.TitleFactory;
import util.Constants;
import util.Strings;

/**
 *	A class that contains all the object to create the StateWin
 */
public class StateWin implements State{

	private PanelBackgroundFactory panel = new PanelBackgroundFactory(Strings.PANEL_BACKGROUND);
	private JPanel southPanel = new JPanel();
	private JPanel centralPanel = new JPanel();
	private LabelFactory labelFactory = new LabelFactory();
	private JButton button = new JButton("Enter");
	private JTextField textField = new JTextField();
	private TitleFactory titleFactory = new TitleFactory();
	private BufferedReader bufferedReader;
	private Optional<String> lastOnPodium;
	
	/**
	 * The constructor of the StateWin,
	 * this state is showed when the player wins.
	 * @param board
	 * @param score
	 */
	public StateWin(Board board, int score) {
		this.panel.setLayout(new BorderLayout());
		this.centralPanel.setLayout(new BorderLayout());
		this.southPanel.setOpaque(false);
		this.centralPanel.setOpaque(false);
		this.southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.PAGE_AXIS));
		this.panel.add(this.centralPanel, BorderLayout.SOUTH);
		this.centralPanel.add(southPanel);
		
		try {
			this.bufferedReader = new BufferedReader(new FileReader(Strings.LEADERBOARD_URI));
				
			for(int i=Constants.minPodium; i<=Constants.maxPodium; i++) {
				if(i==Constants.maxPodium) {
					this.lastOnPodium = Optional.ofNullable(bufferedReader.readLine());
				} else {
					bufferedReader.readLine();
				}
			}
			String[] lastOnPodiumArray = lastOnPodium.get().split(" ");
			if(this.lastOnPodium.get().equals(Strings.LEADERBOARD_DEFAULT_TEXT) || this.lastOnPodium.get().equals("") ||
					 Integer.parseInt(lastOnPodiumArray[lastOnPodiumArray.length-1]) < score) {
				this.southPanel.add(this.textField);
				this.southPanel.add(this.button);
				this.textField.setMaximumSize(Constants.maxTextFieldDimension);
				this.button.setBackground(Color.gray);
				this.button.setForeground(Color.white);
				this.button.setAlignmentX(Component.CENTER_ALIGNMENT);
				this.button.setPreferredSize(Constants.maxButtonDimension);
				this.panel.add(this.titleFactory.createTitle("Congratulation, Please insert your nickname(max " + Constants.maxLeaderboardCharacters + " characters)",
						Constants.subtitleSize, Constants.colorSubtitle), BorderLayout.NORTH);
				this.button.addActionListener(e->{
					if(this.textField.getText().equals("")) {
						try {
							 Files.write(Paths.get(Strings.LEADERBOARD_URI), ("Anonymous score: " + score).getBytes(), StandardOpenOption.APPEND);
							board.setCurrentState(new StateLeaderboard(board));
						} catch (IOException e1) {
							System.out.println("there was a problem with the leaderboard file");
						}
					} else {
						if(this.textField.getText().length() > Constants.maxLeaderboardCharacters) {
							this.textField.setText("You have to insert max " + Constants.maxLeaderboardCharacters + " characters.");
						} else {
							try {
								Files.write(Paths.get(Strings.LEADERBOARD_URI), (this.textField.getText() + " score: " + score).getBytes(), StandardOpenOption.APPEND);
									board.setCurrentState(new StateLeaderboard(board));
							} catch (IOException e1) {
								System.out.println("there was a problem with the leaderboard file");
							}
						}
					}	
				});
				
			} else{
				this.panel.add(this.labelFactory.createButton(Strings.GO_BACK_TO_MENU, board, "Center"), BorderLayout.CENTER);
			}
		} catch (IOException e) {
			this.panel.add(this.labelFactory.createButton(Strings.GO_BACK_TO_MENU, board, "Center"), BorderLayout.SOUTH);
			System.out.println("there was a problem with the leaderboard file");
		}
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}

}
