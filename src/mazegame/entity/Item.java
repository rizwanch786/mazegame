package mazegame.entity;

public class Item {
	String name;
	int price;
	double weight;
	String description;
	boolean equiped;

	public Item(String name, int price, double weight, String description) {
		super();
		this.name = name.toLowerCase();
		this.price = price;
		this.weight = weight;
		this.description = description;
		this.equiped = false;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isEquiped() {
		return equiped;
	}

	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}

}
