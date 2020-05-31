package mazegame.control;

import mazegame.entity.Player;

/**
 * @author RanaShahzad
 *
 */
public class QuitCommand implements Command {

	public CommandResponse execute(ParsedInput input, Player thePlayer) {
		return new CommandResponse("Thanks for playing --- Goodbye", true);
	}
}
