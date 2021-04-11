package menu.factories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import util.Constants;
import util.Pair;
import util.Strings;
/**
 * A class that reads a file and make a leaderboard from that infos,
 * then write on the same file the leaderboard created.
*/
public class LeaderboardFactory {

	private List<Pair<Optional<String>, Integer>> leaderboardList = new ArrayList<>();
	private List<String> list = new ArrayList<>();
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	
	/**
	 * A method that reads a file and create a leaderboard from that,
	 * than write the leaderboard created on the same file.
	 * 
	 * @return a List of stings containing the leaderboard infos.
	 */
	public List<String> getLeaderboardList(){
		
		try {
			this.bufferedReader = new BufferedReader(new FileReader(Strings.LEADERBOARD_URI));
			
			for(int i=Constants.minPodium; i<=Constants.maxPodium+1; i++) {
				Optional<String> position = Optional.ofNullable(bufferedReader.readLine());
				
				if(position.isEmpty() || position.get().equals("") || position.get().equals(Strings.LEADERBOARD_DEFAULT_TEXT)) {
					position = Optional.of(Strings.LEADERBOARD_DEFAULT_TEXT);
					this.leaderboardList.add(new Pair<>(position, 0));
				} else {
					String[] lineSplitted = position.get().split(" ");
					int lineScore = Integer.parseInt(lineSplitted[lineSplitted.length-1]);
					this.leaderboardList.add(new Pair<>(position, lineScore));
				}
				
				this.leaderboardList.sort(new Comparator<Pair<Optional<String>, Integer>>() {

					@Override
					public int compare(Pair<Optional<String>, Integer> o1,
							Pair<Optional<String>, Integer> o2) {
						return o2.getY() - o1.getY();
					}
				});
			}
			this.leaderboardList.remove(Constants.maxPodium);
			this.bufferedWriter = new BufferedWriter(new FileWriter(Strings.LEADERBOARD_URI));
			for(var line : this.leaderboardList) {
				String stringToWrite = line.getX().get();
				this.list.add(stringToWrite);
				this.bufferedWriter.write(stringToWrite);
				this.bufferedWriter.newLine();
			}
			this.bufferedWriter.close();
			
		} catch (IOException e) {
			System.out.println("cannot find the file");
		}
		
		return list;
	}
}
