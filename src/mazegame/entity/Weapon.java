package mazegame.entity;

public class Weapon extends Item {
	public Dice m_Dice;
	int combatPower;

	public Weapon(String name, int value, double weight, String desc,int combatpower) {
		super(name, value, weight, desc);
		this.combatPower=combatpower;
	}

	public int getCombatPower() {
		return combatPower;
	}

	public void setCombatPower(int combatPower) {
		this.combatPower = combatPower;
	}
}
