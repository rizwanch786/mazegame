package mazegame.control;

import mazegame.entity.Exit;
import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;

/**
 * @author RanaShahzad
 *
 */
public class MoveCommand implements Command {

	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		StringBuilder message = new StringBuilder();
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse("If you want to move you need to tell me where.");
		}
		String exitLabel = (String) userInput.getArguments().get(0);
		Exit desiredExit = thePlayer.getCurrentLocation().getExit(exitLabel);
		if (desiredExit == null) {
			return new CommandResponse("There is no exit try moving somewhere else!");
		}
		thePlayer.setCurrentLocation(desiredExit.getDestination());
		message.append("You successfully move " + exitLabel + " and find yourself at "
				+ thePlayer.getCurrentLocation().toString() + thePlayer.getCurrentLocation().getNPCDetails() + "\n");
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
		return new CommandResponse(message.toString());
	}

}
