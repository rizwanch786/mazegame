package mazegame.entity;

import java.util.Formatter;
import java.util.HashMap;

public class Inventory {
	private Money gold;
	private HashMap<String, Item> itemList;

	public Inventory() {
		gold = new Money();
		itemList = new HashMap<String, Item>();
	}

	public void addMoney(int goldPieces) {
		gold.Add(goldPieces);
	}

	public boolean removeMoney(int goldPieces) {
		return gold.Subtract(goldPieces);
	}

	public boolean addItem(Item theItem) {
		itemList.put(theItem.getName(), theItem);
		return true;
	}

	public Item removeItem(String itemName) {
		if (itemList.containsKey(itemName)) {
			itemList.remove(itemName);
			return itemList.get(itemName);
		}
		// else return ("That item isn't here to remove");
		else
			return null;
	}

	public String printItemList() {
		if (itemList.size() == 0)
			return "No items here";
		StringBuilder returnMsg = new StringBuilder();
		Formatter formatter = new Formatter(returnMsg);
		String format = "%-37s %-65s %-9s %-9s";
		// returnMsg.append("The list of Items here ::\n");
		Boolean first = true;
		Boolean second = true;
		Boolean third = true;
		for (String item : itemList.keySet()) {
			if (itemList.get(item) instanceof Armor) {
				if (first) {
					returnMsg.append(
							"\n******************************************************** || ARMOURS || ********************************************************\n\n");
					returnMsg.append(
							"-------------------------------------------------------------------------------------------------------------------------------\n");
					formatter.format(format, "Item Name", "Description", "Price($)", "Weight(lb)\n");
					returnMsg.append(
							"-------------------------------------------------------------------------------------------------------------------------------\n");
					first = false;
				}
				formatter.format(format, itemList.get(item).getName(), itemList.get(item).getDescription(),
						itemList.get(item).getPrice(), itemList.get(item).getWeight());

				returnMsg.append("\n");
			}
		}

		for (String item : itemList.keySet()) {
			if (itemList.get(item) instanceof Weapon) {
				if (second) {
					returnMsg.append(
							"\n\n******************************************************** || WEAPONS || ********************************************************\n\n");
					returnMsg.append(
							"-------------------------------------------------------------------------------------------------------------------------------\n");
					formatter.format(format, "Item Name", "Description", "Price($)", "Weight(lb)\n");
					returnMsg.append(
							"-------------------------------------------------------------------------------------------------------------------------------\n");

					second = false;
				}
				formatter.format(format, itemList.get(item).getName(), itemList.get(item).getDescription(),
						itemList.get(item).getPrice(), itemList.get(item).getWeight());

				returnMsg.append("\n");
			}
		}

		for (String item : itemList.keySet()) {

			if (itemList.get(item) instanceof Shield) {
				if (third) {
					returnMsg.append(
							"\n\n******************************************************** || SHIELDS || ********************************************************\n\n");
					returnMsg.append(
							"-------------------------------------------------------------------------------------------------------------------------------\n");
					formatter.format(format, "Item Name", "Description", "Price($)", "Weight(lb)\n");
					returnMsg.append(
							"-------------------------------------------------------------------------------------------------------------------------------\n");
					third = false;
				}
				formatter.format(format, itemList.get(item).getName(), itemList.get(item).getDescription(),
						itemList.get(item).getPrice(), itemList.get(item).getWeight());
				returnMsg.append("\n");
			}
		}
		returnMsg.append("\n\n");
		formatter.close();
		return returnMsg.toString();

	}

	public String printMoney() {
		return gold.toString();
	}

	public HashMap<String, Item> getItemList() {
		return itemList;
	}

	public Item findItem(String itemLabel) {
		if (itemList.containsKey(itemLabel)) {
			return itemList.get(itemLabel);
		} else {
			return null;
		}

	}

	public Money getMoney() {
		return this.gold;
	}

}
