package mazegame.entity;

public class Armor extends Item {
	int healthpower;

	public int getProtection() {
		return healthpower;
	}

	public void setProtection(int protection) {
		this.healthpower = protection;
	}

	public Armor(String name, int value, double weight, String desc,int protection) {
		super(name, value, weight, desc);
		this.healthpower=protection;
	}

}
