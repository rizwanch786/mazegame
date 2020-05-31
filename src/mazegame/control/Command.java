package mazegame.control;

import mazegame.entity.Player;

public interface Command {
	public abstract CommandResponse execute(ParsedInput userInput, Player thePlayer);
}
