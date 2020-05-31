package mazegame.entity;

public class Character {
	private int agility;
	private int lifePoints;
	private String name;
	private int strength;
	// public Mazegame.Entity.Dice m_Dice;
	// public Mazegame.Entity.Party m_Party;
	// public Mazegame.Entity.Item m_Item;
	// public Mazegame.Entity.Shield m_Shield;
	// public Mazegame.Entity.Weapon m_Weapon;
	// public Mazegame.Entity.Armor m_Armor;

	public Character() {
	}

	public Character(String name) {
		this.agility = 35;
		this.lifePoints = 35;
		this.name = name;
		this.strength = 35;
	}

	public Character(int agility, int lifePoints, String name, int strength) {
		this.agility = agility;
		this.lifePoints = lifePoints;
		this.name = name;
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
}
