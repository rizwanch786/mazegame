package mazegame.control;

import mazegame.entity.Exit;
import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;

/**
 * @author RanaShahzad
 *
 */
public class LookCommand implements Command {

	private CommandResponse response;
	private StringBuilder message = new StringBuilder();

	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		response = new CommandResponse("Can't find that to look at here!");
		if (userInput.getArguments().size() == 0) {
			message.append(
					thePlayer.getCurrentLocation().toString() + thePlayer.getCurrentLocation().getNPCDetails() + "\n");

			if (!thePlayer.getCurrentLocation().getNpcs().isEmpty()) {
				for (Object npc : thePlayer.getCurrentLocation().getNpcs().values()) {
					if (((NonPlayerCharacter) npc).isHostile()) {
						message.append("Warning !! There is a hostile character in this room ["
								+ ((NonPlayerCharacter) npc).getName() + "]!!\n");
						message.append("You can either flee using move command \n"
								+ "or you can fight using equip command to get ready.\n");

					}
				}
			}
			if (thePlayer.getCurrentLocation().hasBlacksmith()) {
				message.append("There is a blacksmith in this room. You can buy and sell items here.\n");
				message.append(thePlayer.getCurrentLocation().getBlacksmith().getStorage().printItemList());
				message.append(thePlayer.getCurrentPlayerStat(thePlayer));
			} else if (!thePlayer.getCurrentLocation().getInventory().getItemList().isEmpty()) {
				message.append("Wow "+thePlayer.getName().toUpperCase()+", you found some items!! Use get command to pickup free items.\n\n");
				message.append(thePlayer.getCurrentLocation().getInventory().printItemList());

			} else {
				message.append("No Items in this location.");
			}
			response.setMessage(message.toString());
			return response;
		}
		for (Object argument : userInput.getArguments()) {
			if (thePlayer.getCurrentLocation().containsExit(argument.toString())) {
				Exit theExit = thePlayer.getCurrentLocation().getExit((String) argument);
				return new CommandResponse(theExit.getDescription());
			}
		}
		return response;
	}
}
