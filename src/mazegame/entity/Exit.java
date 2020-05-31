package mazegame.entity;

public class Exit {
	private String description;
	private Location destination;

	public Exit(String description, Location destination) {
		this.setDescription(description);
		this.setDestination(destination);
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
