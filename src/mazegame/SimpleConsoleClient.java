package mazegame;

import java.util.Scanner;
import mazegame.boundary.IMazeClient;

public class SimpleConsoleClient implements IMazeClient {

	public String getReply(String question) {
		System.out.println("\n" + question + " ");
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

	public void playerMessage(String message) {
		System.out.print(message);
	}

	public String getCommand() {
		System.out.print("\n\n>>>\t");
		return new Scanner(System.in).nextLine();
	}
}
