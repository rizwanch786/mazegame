package mazegame.control;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
	private ArrayList<String> dropWords;
	private ArrayList<String> validCommands;

	public Parser(ArrayList<String> validCommands) {
		dropWords = new ArrayList<String>(Arrays.asList("an", "and", "the", "this", "to"));
		this.validCommands = validCommands;
	}

	public ParsedInput parse(String rawInput) {
		ParsedInput parsedInput = new ParsedInput();
		String lowercaseInput = rawInput.toLowerCase();
		ArrayList<String> stringTokens = new ArrayList<String>(Arrays.asList(lowercaseInput.split(" ")));

		for (String token : stringTokens) {

			if (validCommands.contains(token)) {
				parsedInput.setCommand(token);
			} else if (!dropWords.contains(token))
				parsedInput.getArguments().add(token);
		}
		return parsedInput;
	}
}
