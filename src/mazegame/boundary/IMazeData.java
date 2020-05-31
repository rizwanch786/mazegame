package mazegame.boundary;

import mazegame.entity.Location;

public interface IMazeData {
	Location getStartingLocation();

	String getWelcomeMessage();
}
