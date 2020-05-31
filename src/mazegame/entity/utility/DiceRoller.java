package mazegame.entity.utility;

import java.util.ArrayList;
import java.util.Collections;

import mazegame.entity.Dice;

/**
 * @author RanaShahzad
 *
 */
public class DiceRoller {
	private static DiceRoller instance = new DiceRoller();
	private Dice d6;

	private DiceRoller() {
		d6 = new Dice(6);
	}

	public static DiceRoller GetInstance() {
		return instance;
	}

	public int generateAbilityScore() {
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			results.add(d6.roll());
		}

		Collections.sort(results);
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += results.get(i);
		}
		return sum;
	}

}
