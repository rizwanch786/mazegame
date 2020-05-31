package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;
/**
 * @author Rana_Shahzad
 *
 */
public class dropItemsCommand implements Command {
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {

		StringBuilder message = new StringBuilder();
if(thePlayer.getInventory().getItemList().isEmpty()) {
	return new CommandResponse("you don't have any item in your bag to drop.");
}
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse("If you want to drop an item, you need to tell what you want to drop.");
		}

		String itemName = userInput.getArguments().get(0).toString();

		if (thePlayer.getInventory().getItemList().containsKey(itemName)) {
			// Finding and getting the item requested
			Item item = thePlayer.getInventory().findItem(userInput.getArguments().get(0).toString());

			// Now Can successfully sell so adding and removing item
			thePlayer.getCurrentLocation().getInventory().addItem(item);
			thePlayer.getInventory().removeItem(itemName);

			item.setPrice((int) (item.getPrice() * 0.9));// The price of item is now degraded by 10%

			// Now printing the status after the player has selling the item
			message.append("You have successfully dropped the " + itemName + "\n");
			message.append(thePlayer.getCurrentPlayerStat(thePlayer));

		} else {
			message.append(
					"There is no such items in your bag, \nPlease tell the name of item from your bag if you want to drop.\n");
			message.append(thePlayer.getInventory().printItemList());

		}

		return new CommandResponse(message.toString());
	}

}
