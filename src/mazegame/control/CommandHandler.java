package mazegame.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import mazegame.entity.Player;

public class CommandHandler {
	private HashMap<String, Command> availableCommands;
	private Parser theParser;

	public CommandHandler() {
		availableCommands = new HashMap<String, Command>();
		setupCommands();
		theParser = new Parser(popArrayList());
	}

	private void setupCommands() {
		availableCommands.put("go", new MoveCommand());
		availableCommands.put("quit", new QuitCommand());
		availableCommands.put("move", new MoveCommand());
		availableCommands.put("look", new LookCommand());
		availableCommands.put("list", new listItemsCommand());
		availableCommands.put("get", new getItemsCommand());
		availableCommands.put("pick", new getItemsCommand());
		availableCommands.put("drop", new dropItemsCommand());
		availableCommands.put("equip", new equipItemCommand());
		availableCommands.put("unequip", new unequipItemCommand());
		availableCommands.put("purchase", new purchaseItemCommand());
		availableCommands.put("buy", new purchaseItemCommand());
		availableCommands.put("sell", new sellItemCommand());
		availableCommands.put("status", new getMazeStatusCommand());
		availableCommands.put("help", new helpCommand());
		availableCommands.put("fight", new fightCommand());
		availableCommands.put("stat", new statCommand());
	}

	private ArrayList<String> popArrayList() {
		Set<String> set = availableCommands.keySet();
		ArrayList<String> temp = new ArrayList<String>();
		for (String key : set) {
			temp.add(key);
		}
		return temp;
	}

	public CommandResponse processTurn(String userInput, Player thePlayer) {
		ParsedInput validInput = theParser.parse(userInput);
		Command theCommand = (Command) availableCommands.get(validInput.getCommand());
		if (theCommand != null)
			return theCommand.execute(validInput, thePlayer);
		else
			return new CommandResponse("Invalid command, Please use the help command to see valid commands:\n\n");

	}

}
