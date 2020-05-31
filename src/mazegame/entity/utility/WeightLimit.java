package mazegame.entity.utility;

import java.util.Collections;
import java.util.HashMap;

public class WeightLimit {
	private static WeightLimit instance;
	private HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();

	private WeightLimit(HashMap<Integer, Integer> theTable) {
		lookup = theTable;
	}

	public static WeightLimit getInstance() {
		if (instance == null) {
			instance = new WeightLimit(new HashMap<Integer, Integer>());
		}
		return instance;
	}

	public void setModifier(int strength, int weightLimit) {
		lookup.put(strength, weightLimit);
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
