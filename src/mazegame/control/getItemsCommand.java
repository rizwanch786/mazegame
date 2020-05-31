package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

/**
 * @author RanaShahzad
 *
 */
public class getItemsCommand implements Command {
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {

		StringBuilder message = new StringBuilder();
		if (!thePlayer.getCurrentLocation().getInventory().getItemList().isEmpty()) {
			if (userInput.getArguments().size() == 0) {
				return new CommandResponse("If you want to pick an item, you need to tell what you want to get.");
			}
		} else {
			return new CommandResponse("There is no items in this room, you cannot pick up any items here.");
		}
		String itemName = userInput.getArguments().get(0).toString();

		if (thePlayer.getCurrentLocation().getInventory().getItemList().containsKey(itemName)) {
			double weightLimit = thePlayer.getInventory().getWeightLimit();// Total weight player can carry
			double currentWeight = thePlayer.getInventory().getWeight();// Current weight player is carrying

			// Finding and getting the item requested
			Item item = thePlayer.getCurrentLocation().getInventory()
					.findItem(userInput.getArguments().get(0).toString());
			// Checking if the the player has the golds to pay for this item and also to
			// check the weight limit
			// of player is not exceeded if the player buy the item
			if (item.getWeight() <= (weightLimit - currentWeight)) {
				// Now Can successfully purchase so adding and removing item
				thePlayer.getCurrentLocation().getInventory().removeItem(itemName);
				thePlayer.getInventory().addItem(item);

				// Now printing the status after the player has purchased the item
				message.append("You have successfully picked the " + itemName + "\n");
				message.append(thePlayer.getCurrentPlayerStat(thePlayer));

			} else {
				message.append(
						"You don't have enough space to carry this item. Please check your resource and try again!!\n");
				message.append(thePlayer.getCurrentPlayerStat(thePlayer));
			}

		} else {
			message.append("There is no such items here, Please pick up given items in list\n");
			message.append(thePlayer.getCurrentLocation().getInventory().printItemList());

		}

		return new CommandResponse(message.toString());
	}
}
