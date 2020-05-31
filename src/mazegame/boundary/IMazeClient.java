package mazegame.boundary;

public interface IMazeClient {
	public String getReply(String question);

	public void playerMessage(String message);

	public String getCommand();
}
