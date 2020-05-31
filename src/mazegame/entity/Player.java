package mazegame.entity;

public class Player extends Character {

	private Location currentLocation;
	private Party myParty;
	private FiniteInventory myinventory;

	public Player() {
	}

	public Player(String name) {
		super(name);
		myinventory = new FiniteInventory(super.getStrength());
		myParty = new Party("Default Dungueon Party");
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Party getMyParty() {
		return myParty;
	}

	public void setMyParty(Party myParty) {
		this.myParty = myParty;
	}

	public void addItem(Item item) {
		myinventory.addItem(item);
	}

	public FiniteInventory getInventory() {
		return this.myinventory;
	}

	public String getCurrentPlayerStat(Player player) {
		StringBuilder message = new StringBuilder();
		message.append("Hello " + player.getName().toUpperCase() + ",\n");
		message.append("Your current Status is: \n");
		message.append("You have agility: " + player.getAgility() + "\n");
		message.append("You have lifepoint: " + player.getLifePoints() + "\n");
		message.append("You have strength: " + player.getStrength() + "\n");
		message.append("Your weight Limit is: " + player.getInventory().getWeightLimit() + "\n");
		message.append("Your party is: " + player.getMyParty().getName() + "\n");
		message.append(player.getInventory().printMoney() + "\n");
		message.append("Your total item weight is: " + player.getInventory().getWeight() + "\n");
		
		return message.toString();
	}
	public String getCurrentPlayerItems(Player player) {
		StringBuilder message = new StringBuilder();
		if (!player.getInventory().getItemList().isEmpty()) {
			message.append(player.getInventory().printItemList() + "\n");
		} else {
			message.append("You currently have no items");
		}
		return message.toString();
	}

}
