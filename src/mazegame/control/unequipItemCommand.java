package mazegame.control;

import mazegame.entity.Armor;
import mazegame.entity.Item;
import mazegame.entity.Player;
import mazegame.entity.Shield;
import mazegame.entity.Weapon;
import mazegame.entity.utility.AgilityTable;

/**
 * @author RanaShahzad
 *
 */
public class unequipItemCommand implements Command {
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {

		StringBuilder message = new StringBuilder();

		if (userInput.getArguments().size() == 0) {

			message.append(
					"If you want to unwear or unweild an item, you need to tell what you want to unwear/unwield.");
			message.append(thePlayer.getInventory().printItemList());
			return new CommandResponse(message.toString());
		}

		String itemName = userInput.getArguments().get(0).toString();

		if (thePlayer.getInventory().getItemList().containsKey(itemName)) {
			// Finding and getting the item requested
			Item item = thePlayer.getInventory().findItem(userInput.getArguments().get(0).toString());
			if (item.isEquiped()) {
				// Now Can successfully sell so adding and removing item
				thePlayer.setAgility(
						thePlayer.getAgility() + AgilityTable.getInstance().getModifier((int) item.getWeight()));
				if (item instanceof Armor) {
					thePlayer.setLifePoints(thePlayer.getLifePoints() - ((Armor) item).getProtection());
					message.append("The player has successfully took off the " + item.getName() + " armour.\n");
				} else if (item instanceof Weapon) {
					thePlayer.setStrength(thePlayer.getStrength() - ((Weapon) item).getCombatPower());
					message.append("The player has successfully unweild the " + item.getName() + " weapon.\n");
				} else if (item instanceof Shield) {
					thePlayer.setLifePoints(thePlayer.getLifePoints() - ((Shield) item).getProtection());
					message.append("The player has successfully unwield the " + item.getName() + " shield.\n");
				}
				message.append(thePlayer.getCurrentPlayerStat(thePlayer));
				
				item.setEquiped(false);
			} else {
				message.append("You are not wearing/holding the " + item.getName() + "\n");
				message.append("Please select another item from following list:");
				message.append(thePlayer.getInventory().printItemList());

			}
		} else {
			message.append(
					"There is no such items you are holding, \nPlease tell the name of item you are holding if you want to unwear/unweild it.\n");
			message.append(thePlayer.getInventory().printItemList());

		}

		return new CommandResponse(message.toString());
	}

}
