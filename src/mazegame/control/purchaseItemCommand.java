package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

/**
 * @author RanaShahzad
 *
 */
public class purchaseItemCommand implements Command{
public CommandResponse execute (ParsedInput userInput, Player thePlayer) {

		StringBuilder message = new StringBuilder();
		if (thePlayer.getCurrentLocation().hasBlacksmith()) {
			if (userInput.getArguments().size() == 0) {
				return new CommandResponse(
						"If you want to purchase an item, you need to tell what you want to purchase.");
			}
		} else {
			return new CommandResponse("There is no blacksmith in this room, you cannot purchase any items here.");
		}
		String itemName = userInput.getArguments().get(0).toString();

		if (thePlayer.getCurrentLocation().getBlacksmith().getStorage().getItemList().containsKey(itemName)) {
			double weightLimit = thePlayer.getInventory().getWeightLimit();// Total weight player can carry
			double currentWeight = thePlayer.getInventory().getWeight();// Current weight player is carrying
			int numberOfGolds = thePlayer.getInventory().getMoney().getTotal();// The number of golds player has
			// Finding and getting the item requested
			Item item = thePlayer.getCurrentLocation().getBlacksmith().getStorage()
					.findItem(userInput.getArguments().get(0).toString());
			// Checking if the the player has the golds to pay for this item and also to
			// check the weight limit
			// of player is not exceeded if the player buy the item
			if (item.getPrice() <= numberOfGolds && item.getWeight() <= (weightLimit - currentWeight)) {
				// Now Can successfully purchase so adding and removing item
				thePlayer.getCurrentLocation().getBlacksmith().getStorage().removeItem(itemName);
				thePlayer.getInventory().addItem(item);

				// adding and removing money
				thePlayer.getInventory().removeMoney(item.getPrice());
				thePlayer.getCurrentLocation().getBlacksmith().getStorage().addMoney(item.getPrice());

				// Now printing the status after the player has purchased the item
				message.append("You have successfully purchased the " + itemName + "\n");
				message.append(thePlayer.getCurrentPlayerStat(thePlayer));

			} else {
				message.append(
						"You don't have enough space or money to buy this item. Please check your resource and try again!!\n");
				message.append(thePlayer.getCurrentPlayerStat(thePlayer));
			}

		} else {
			message.append("There is no such items in this store, Please purchase given items in list\n");
			message.append(thePlayer.getCurrentLocation().getBlacksmith().getStorage().printItemList());

		}

		return new CommandResponse(message.toString());
	}
}
