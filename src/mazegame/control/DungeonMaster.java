package mazegame.control;

import mazegame.boundary.IMazeClient;
import mazegame.boundary.IMazeData;
import mazegame.entity.Player;

public class DungeonMaster {
	private IMazeClient gameClient;
	private IMazeData gameData;
	private Player thePlayer;
	private CommandHandler playerTurnHandler;

	public DungeonMaster(IMazeData gameData, IMazeClient gameClient) {
		this.gameData = gameData;
		this.gameClient = gameClient;
		playerTurnHandler = new CommandHandler();
	}

	public void printWelcome() {
		gameClient.playerMessage(gameData.getWelcomeMessage());
	}

	public void setupPlayer() {
		String playerName = gameClient.getReply("What name do you choose to be known by?");
		thePlayer = new Player(playerName);
		thePlayer.getInventory().addMoney(500);// Intital value of gold pieces
		thePlayer.setCurrentLocation(gameData.getStartingLocation());
		gameClient.playerMessage("Welcome " + playerName.toUpperCase() + "\n\n");
		gameClient.playerMessage(gameData.getStartingLocation().getDescription());
		System.out.println("\n" + thePlayer.getCurrentLocation().availableExits());
		System.out.println(thePlayer.getCurrentLocation().getNPCDetails());
		System.out.println(thePlayer.getCurrentLocation().getInventory().printItemList());
		// gameClient.getReply("<<Hit Enter to exit>>");
	}

	public void runGame() {
		printWelcome();
		setupPlayer();
		while (handlePlayerTurn()) {
			// handle npc logic later
		}
		gameClient.getReply("\n\n<<Hit enter to exit>>");
	}

	private boolean handlePlayerTurn() {
		CommandResponse playerResponse = playerTurnHandler.processTurn(gameClient.getCommand(), thePlayer);
		gameClient.playerMessage(playerResponse.getMessage());
		return !playerResponse.isFinishedGame();
	}
}
