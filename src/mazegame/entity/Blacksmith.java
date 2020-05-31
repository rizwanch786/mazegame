package mazegame.entity;

public class Blacksmith extends NonPlayerCharacter {

	private Inventory storage;

	public Blacksmith(String name) {
		super(name);
		storage = new Inventory();
	}

	public void addItem(Item item) {
		storage.addItem(item);
	}

	public Inventory getStorage() {
		return storage;
	}
}