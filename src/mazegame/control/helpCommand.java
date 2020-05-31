package mazegame.control;

import mazegame.entity.Player;

/**
 * @author RanaShahzad
 *
 */
public class helpCommand implements Command {
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if(userInput.getArguments().size()==0)
		return new CommandResponse(commandInfo());
		else
			return new CommandResponse("No parameter accepted for this command!!");
	}

	private String commandInfo() {
		StringBuilder message = new StringBuilder();
		message.append("The list of the commands and how to use it is given below\n\n");
		message.append("go => moves the player from one location to other location, \n\tuse exits as parameter\n\tSyntax -- go <Direction>\n\n");
		message.append("quit => quits the game,\n\tno parameter required\n\tSyntax -- quit\n\n");
		message.append("move => moves the player from one location to other location, \n\tuse exits as parameter\n\tSyntax -- move <Direction>\n\n");
		message.append(
				"look => looks around the player, with or without parameter, \n\tcan provided exit as parameter\n\tSyntax -- look <Direction> or look\n\n");
		message.append("list => gives the list of the items player holds,\n\tno parameters required\n\tSyntax -- list\n\n");
		message.append("get => collects new item, \n\tgive the name of the item as parameter\n\tSyntax -- get <Item name>\n\n");
		message.append("pick => collects new item, \n\tgive the name of the item as parameter\n\tSyntax -- get <Item name>\n\n");
		
		message.append(
				"drop => drops the item from players bag, \n\tgive the name of the item player has as parameter\n\tSyntax -- drop <Item name> \n\n");
		message.append(
				"equip => wear/wield the item in the bag,\n\tgive the name of the item player has as parameter\n\tSyntax -- equip <Item name> \n\n");
		message.append(
				"unequip => unwield the item player is wielding,\n\tgive name of the item player wearing/welding as parameter\n\tSyntax -- unequip <Item name> \n\n");
		message.append("purchase => buy an item from a vendor, \n\tgive name of item to buy as parameter\n\tSyntax -- buy <Item name> \n\n");
		message.append("buy => buy an item from a vendor, \n\tgive name of item to buy as parameter\n\tSyntax -- buy <Item name> \n\n");
		
		message.append("sell => sell an item to a vendor,\n\tgive name of item to sell as parameter\n\tSyntax -- sell <Item name> \n\n");
		message.append("status => gives the status of the maze,\n\tno parameter accepted\n\tSyntax -- status \n\n");
		message.append("fight => to battle with the hostile character,\n\tgive name of hostile character as parameter\n\tSyntax -- fight <Hostile Character name> \n\n");
		message.append("stat => gets the statistics of player,\n\tno parameter accepted\n\tSyntax -- stat\n\n");
		message.append("help => gets the list of all the commands applicable,\n\tno parameter accepted\n\tSyntax -- help\n\n");
		
		return message.toString();
	}
}
