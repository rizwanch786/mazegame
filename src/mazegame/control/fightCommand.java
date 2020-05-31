package mazegame.control;

import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;
import mazegame.entity.utility.DiceRoller;

/**
 * @author RanaShahzad
 *
 */
public class fightCommand implements Command {
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		StringBuilder message = new StringBuilder();
		if (!thePlayer.getCurrentLocation().getNpcs().isEmpty()) {
			for (Object npc : thePlayer.getCurrentLocation().getNpcs().values()) {
				if (((NonPlayerCharacter) npc).isHostile()) {
					if (userInput.getArguments().size() == 0) {
						return new CommandResponse(
								"If you want to fight give the name of the hostile character present here.");
					} else {

						if (!(userInput.getArguments().get(0).toString().toLowerCase()
								.equals(((NonPlayerCharacter) npc).getName().toLowerCase()))) {
							return new CommandResponse(
									"If you want to fight give the name of the hostile character present here.");
						}
						boolean playerTurn = true;
						while (((NonPlayerCharacter) npc).getLifePoints() > 0 && thePlayer.getLifePoints() > 0) {
							if (playerTurn) {
								int attackDamage = DiceRoller.GetInstance().generateAbilityScore();
								((NonPlayerCharacter) npc)
										.setLifePoints(((NonPlayerCharacter) npc).getLifePoints() - attackDamage);
								playerTurn = false;
							} else {
								int npcAttack = DiceRoller.GetInstance().generateAbilityScore();
								thePlayer.setLifePoints(thePlayer.getLifePoints() - npcAttack);
								playerTurn = true;
							}
							message.append(((NonPlayerCharacter) npc).getCurrentPlayerStat(thePlayer));
							message.append(((NonPlayerCharacter) npc).getCurrentPlayerStat((NonPlayerCharacter) npc)+"\n");
						}
						if (thePlayer.getLifePoints() <= 0) {
							message.append(
									"You have lost the match with the " + ((NonPlayerCharacter) npc).getName() + "\n");
							return new CommandResponse(message.toString(), true);

						} else if (((NonPlayerCharacter) npc).getLifePoints() <= 0) {
							message.append(
									"You have won the match with the " + ((NonPlayerCharacter) npc).getName() + "\n");
							int bonus = DiceRoller.GetInstance().generateAbilityScore() * 50;
							thePlayer.getInventory().addMoney(bonus);
							message.append("Congratulations!! you get " + bonus + " gold coins as bonus. \n");
							message.append(thePlayer.getCurrentPlayerStat(thePlayer));
							thePlayer.getCurrentLocation().removeNPC(((NonPlayerCharacter) npc));
						}
					}
					return new CommandResponse(message.toString());
				}
			}
			message.append("There is no hostile character to fight with.");

		} else {
			message.append("There is no hostile character to fight with.");
		}

		return new CommandResponse(message.toString());
	}
}
