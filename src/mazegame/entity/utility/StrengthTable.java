package mazegame.entity.utility;

import java.util.Collections;
import java.util.HashMap;

public class StrengthTable {
	private static StrengthTable instance;

	private HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();

	private StrengthTable(HashMap<Integer, Integer> theTable) {
		lookup = theTable;
	}

	public static StrengthTable getInstance() {
		if (instance == null) {
			instance = new StrengthTable(new HashMap<Integer, Integer>());
		}
		return instance;
	}

	public void setModifier(int strength, int modifier) {
		lookup.put(strength, modifier);
	}

	public int getModifier(int strength) {
		int maxStrength = Collections.max(lookup.keySet());
		if (strength > maxStrength)
			return lookup.get(maxStrength);

		if (lookup.keySet().contains(strength))
			return lookup.get(strength);
		return -1;
	}
}
