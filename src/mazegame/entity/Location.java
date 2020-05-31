package mazegame.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Location {
	private HashMap exits;
	private String description;
	private String label;
	private Inventory items;
	private HashMap npcs;

	public Location() {
	}

	public Location(String description, String label) {
		this.setDescription(description);
		this.setLabel(label);
		exits = new HashMap();
		items = new Inventory();
		npcs = new HashMap();
	}

	public Inventory getInventory() {
		return items;
	}

	public boolean addExit(String exitLabel, Exit theExit) {
		if (exits.containsKey(exitLabel))
			return false;
		exits.put(exitLabel, theExit);
		return true;
	}

	public Exit getExit(String exitLabel) {
		return (Exit) exits.get(exitLabel);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String availableExits() {
		StringBuilder returnMsg = new StringBuilder();
		returnMsg.append("Exits from this location:\n");
		for (Object label : this.exits.keySet()) {
			returnMsg.append("[" + label.toString() + "] ");
		}
		return returnMsg.toString();
	}

	public ArrayList<Exit> getAvailableExits() {
		ArrayList<Exit> temp = new ArrayList<Exit>();
		for (Object label : this.exits.values()) {
			temp.add((Exit) label);
		}
		return temp;
	}

	public boolean containsExit(String exitLabel) {
		return exits.containsKey(exitLabel);
	}

	public String toString() {
		return this.label + "\n" + this.description + "\n\n" + availableExits() + "\n";
	}

	public void addNPC(NonPlayerCharacter npc) {
		if (npc != null)
			npcs.put(npc.getName(), npc);
	}

	public HashMap getNpcs() {
		return npcs;
	}

	public void setNpcs(HashMap npcs) {
		this.npcs = npcs;
	}

	public NonPlayerCharacter getNPC(String npcName) {
		if (npcs.containsKey(npcName))
			return (NonPlayerCharacter) npcs.get(npcName);
		else
			return null;
	}

	public boolean hasBlacksmith() {
		for (Object npc : npcs.values()) {
			if (npc instanceof Blacksmith) {
				return true;
			}
		}
		return false;
	}

	public Blacksmith getBlacksmith() {
		if (hasBlacksmith()) {
			for (Object npc : npcs.values()) {
				if (npc instanceof Blacksmith) {
					return (Blacksmith) npc;
				}
			}
		}
		return null;
	}

	public void removeNPC(NonPlayerCharacter npc) {
		if (npcs.containsKey(npc))
			npcs.remove(npc.getName());
	}

	public String getNPCDetails() {
		StringBuffer buffer = new StringBuffer();
		if (npcs.size() > 0) {
			return ("\nSome NPC characters are here : " + npcs.keySet().toString());
		} else {
			return "\nNo NPC charcters present here.";
		}
	}

	public void addItems(Item item) {
		items.addItem(item);
	}
}
