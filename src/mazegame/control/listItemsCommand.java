package mazegame.control;

import mazegame.entity.Player;

/**
 * @author RanaShahzad
 *
 */
public class listItemsCommand implements Command {
	private CommandResponse response;

	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {

		response = new CommandResponse("");
		if (userInput.getArguments().size() == 0) {
			if (!thePlayer.getInventory().getItemList().isEmpty()) {
				response.setMessage("Hello " + thePlayer.getName().toUpperCase()
						+ ",\n You have following items in your bag(list) :\n"
						+ thePlayer.getInventory().printItemList());
				return response;
			} else {
				response.setMessage("Hello " + thePlayer.getName().toUpperCase() + ",\nYou have No items in the bag!");
			}
		} else {
			response.setMessage("No argument accepted with this command.");
		}
		return response;
	}

}
