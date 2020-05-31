package mazegame.entity.utility;

import java.util.Collections;
import java.util.HashMap;

public class AgilityTable {
	private static AgilityTable instance;

	private HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();

	private AgilityTable(HashMap<Integer, Integer> theTable) {
		lookup = theTable;
	}

	public static AgilityTable getInstance() // Notice Singleton
	{
		if (instance == null)
			instance = new AgilityTable(new HashMap<Integer, Integer>());
		return instance;
	}

	public void setModifier(int agility, int modifier) {
		lookup.put(agility, modifier);
	}

	public int getModifier(int agility) {
		int maxAgility = Collections.max(lookup.keySet());
		if (agility > maxAgility)
			return lookup.get(maxAgility);

		if (lookup.keySet().contains(agility))
			return lookup.get(agility);
		return -1;
	}
}
