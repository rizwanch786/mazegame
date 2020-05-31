package mazegame.control;

import java.util.ArrayList;

public class ParsedInput {

	private String command;
	private ArrayList arguments;

	public ParsedInput() {
		setArguments(new ArrayList());
		setCommand("");
	}

	public ParsedInput(String command, ArrayList arguments) {
		this.setCommand(command);
		this.setArguments(arguments);
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public ArrayList getArguments() {
		return arguments;
	}

	public void setArguments(ArrayList arguments) {
		this.arguments = arguments;
	}
}
