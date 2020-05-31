package mazegame.entity;

public class NonPlayerCharacter extends Character {
	private Boolean hostile;
	// private Location cuLocation;

	public NonPlayerCharacter(String name) {
		super(35, 30, name, 35);
		setHostile(false);
		// cuLocation=currentLocation;
	}

	public NonPlayerCharacter(String name, boolean hostile) {
		super(name);
		setHostile(hostile);
		// this.cuLocation=currentLocation;
	}

	public boolean isHostile() {
		return this.hostile;
	}

	public void setHostile(boolean hostile) {
		this.hostile = hostile;
	}

	public String getCurrentPlayerStat(Character player) {
		StringBuilder message = new StringBuilder();
		message.append(player.getName().toUpperCase() + ",\n");
		message.append("You have lifepoint: " + player.getLifePoints() + "\n");

		return message.toString();
	}

}
