package mazegame.control;

import java.util.ArrayList;

import mazegame.entity.Exit;
import mazegame.entity.Location;
import mazegame.entity.Player;

/**
 * @author RanaShahzad
 *
 */
public class getMazeStatusCommand implements Command {
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {

		StringBuilder message = new StringBuilder();

		if (userInput.getArguments().size() == 0) {
			ArrayList<Location> loc = new ArrayList<Location>();
			loc.add(thePlayer.getCurrentLocation());
			loc = getAll(loc, thePlayer.getCurrentLocation());
			int N = 0;
			for (int i = 0; i < loc.size(); i++) {
				if (loc.get(i).hasBlacksmith()) {
					N++;
				}
			}
			message.append("The game has total of (M) " + loc.size() + " locations and (N) " + N
					+ " shops.\n The name of the locations are as follows:\n");
			for (int i = 0; i < loc.size(); i++) {
				message.append(loc.get(i).getLabel() + "\n");
			}
			return new CommandResponse(message.toString());

		} else {
			return new CommandResponse("No need of argument accepted for this command");
		}
	}

	public ArrayList<Location> getAll(ArrayList<Location> locat, Location loc) {
		ArrayList<Exit> temp = new ArrayList<Exit>();
		temp = loc.getAvailableExits();
		for (int i = 0; i < temp.size(); i++) {
			if (!locat.contains(temp.get(i).getDestination())) {
				locat.add(temp.get(i).getDestination());
				getAll(locat, temp.get(i).getDestination());
			}
		}
		return locat;
	}

}
