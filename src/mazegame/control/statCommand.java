package mazegame.control;

import mazegame.entity.Player;

public class statCommand implements Command {
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		StringBuilder message = new StringBuilder();
		if (userInput.getArguments().size() != 0) {
			return new CommandResponse("No argument accepted with this command.");
		}
		message.append(thePlayer.getCurrentPlayerStat(thePlayer));
		return new CommandResponse(message.toString());
	}
}
