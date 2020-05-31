package mazegame.entity;

public class Shield extends Item {
	int protection;

	public Shield(String name, int value, double weight, String desc,int protection) {
		super(name, value, weight, desc);
		this.protection=protection;
	}

	public int getProtection() {
		return protection;
	}

	public void setProtection(int protection) {
		this.protection = protection;
	}

}
