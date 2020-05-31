package mazegame.entity;

public class Money {
	private int total;

	public Money() {
		total = 0;
	}

	public Money(int total) {
		this.total = total;
	}

	public void Add(int amount) {
		total += amount;
	}

	public boolean Subtract(int amount) {
		if (amount > total)
			return false;
		total -= amount;
		return true;
	}

	public double GetWeight() {
		return (double) total / 100;
	}

	public String toString() {
		if (total < 1)
			return "No gold pieces";
		if (total == 1)
			return "One gold piece";
		return "There are " + total + " gold pieces";
	}

	public int getTotal() {
		return this.total;
	}
}
