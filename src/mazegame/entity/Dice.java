package mazegame.entity;

import java.util.Random;

public class Dice {
	private int faces;
	private static Random generator = new Random();

	public Dice(int faces) {
		this.faces = faces;
	}

	public int roll() {
		return generator.nextInt(this.faces) + 1;
	}
}
