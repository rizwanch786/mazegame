package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

/**
 * @author RanaShahzad
 *
 */
public class sellItemCommand implements Command {
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {

		StringBuilder message = new StringBuilder();
		if (thePlayer.getCurrentLocation().hasBlacksmith()) {
			if (userInput.getArguments().size() == 0) {
				return new CommandResponse("If you want to sell an item, you need to tell what you want to sell.");
			}
		} else {
			return new CommandResponse("There is no blacksmith in this room, you cannot sell an items here.");
		}
		String itemName = userInput.getArguments().get(0).toString();

		if (thePlayer.getInventory().getItemList().containsKey(itemName)) {
			// Finding and getting the item requested
			Item item = thePlayer.getInventory().findItem(userInput.getArguments().get(0).toString());

			// Now Can successfully sell so adding and removing item
			thePlayer.getCurrentLocation().getBlacksmith().getStorage().addItem(item);
			thePlayer.getInventory().removeItem(itemName);

			// adding and removing money with 10% cut from original price
			thePlayer.getInventory().addMoney((int) (item.getPrice() * 0.9));
			thePlayer.getCurrentLocation().getBlacksmith().getStorage().removeMoney((int) (item.getPrice() * 0.9));
			item.setPrice((int) (item.getPrice() * 0.9));// The price of item is now degraded by 10%

			// Now printing the status after the player has selling the item
			message.append("You have successfully sold the " + itemName + "\n");
			message.append(thePlayer.getCurrentPlayerStat(thePlayer));

		} else {
			message.append("There is no such items in your bag, Please sell items in your bag.\n");
			message.append(thePlayer.getInventory().printItemList());

		}

		return new CommandResponse(message.toString());
	}
}
