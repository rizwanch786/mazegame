package mazegame;

import mazegame.boundary.IMazeData;
import mazegame.entity.utility.*;
import mazegame.entity.Armor;
import mazegame.entity.Blacksmith;
import mazegame.entity.Exit;
import mazegame.entity.Location;
import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Shield;
import mazegame.entity.Weapon;

public class HardCodedData implements IMazeData {
	private Location startUp;

	public HardCodedData() {
		createLocations();
		populateWeightLimitTable();
		populateStrengthTable();
		populateAgilityTable();
	}

	public Location getStartingLocation() {
		return startUp;
	}

	public String getWelcomeMessage() {
		return "********Welcome to the Maze-Game********";
	}

	private void createLocations() {
		startUp = new Location("You see empty hall with some couch and some people", "Entrance Lobby");
		Location Reception = new Location("You see helpdesk with a receptionist", "Reception Desk");
		Location Lecture101 = new Location("You see a hall with projector, board and some desks and chairs.",
				"Lecture Room 101");
		Location BoardRoom = new Location("You see big desk at the center and some chairs around it.", "Board Room");
		Location Lab201 = new Location(
				"You see a big room with around 30 desktop computers and a white board at the front. ", "Lab Room 201");
		Location Lecture202 = new Location("You see a hall with projector, board and some desks and chairs.",
				"Lecture Room 202");
		Location Lab203 = new Location(
				"You see a big room with around 30 desktop computers and a white board at the front.", "Lab Room 203");
		Location StaffOffice = new Location("You see about 20 cabins with desk, bench, computers and files.",
				"Staff Office");
		Location Library = new Location("You see lots of books on the shelf and a cabin with librarian.", "Library");
		Location Lecture301 = new Location("You see a hall with projector, board and some desks and chairs.",
				"Lecture Room 301");
		Location Cafeteria = new Location(
				"You see a lot of dining tables and chairs, a microwave, a fridge and a vending machine.", "Cafeteria");
		Location ManagementOffice = new Location(
				"You see a room with an expensive looking table, computer, chair, locker with some files.",
				"Manaagement Offcie");
		Location TableTennisRoom = new Location("You see couple of table tennis and some people playing the game.",
				"Table Tennis Room");
		Location Lab401 = new Location(
				"You see a big room with around 30 desktop computers and a white board at the front.", "Lab Room 401");

		// Connect Locations
		startUp.addExit("east", new Exit("you see an open space to the east", Reception));
		Reception.addExit("west", new Exit("you see a help desk to the west", startUp));

		Reception.addExit("north", new Exit("you see a big room to the north", BoardRoom));
		BoardRoom.addExit("south", new Exit("you see a help desk to the south", Reception));

		Reception.addExit("east", new Exit("you see a Lecture hall to the east", Lecture101));
		Lecture101.addExit("west", new Exit("you see a help desk to the west", Reception));

		Lecture101.addExit("northeast", new Exit("you see a lab with desktop computers to the northeast", Lab201));
		Lab201.addExit("southwest", new Exit("you see a lecture hall to the southwest", Lecture101));

		Lecture101.addExit("northwest", new Exit("you see a big room to the northwest", BoardRoom));
		BoardRoom.addExit("southeast", new Exit("you see a lecture hall to the southeast", Lecture101));

		BoardRoom.addExit("north", new Exit("you see a office with cabins to the north", StaffOffice));
		StaffOffice.addExit("south", new Exit("you see a big room to the south", BoardRoom));

		Lab201.addExit("north", new Exit("you see a library to the north", Library));
		Library.addExit("south", new Exit("you see a lab with desktop computers to the south", Lab201));

		Lab201.addExit("east", new Exit("you see a lecutre hall to the east", Lecture202));
		Lecture202.addExit("west", new Exit("you see a lab with desktop computers to the west", Lab201));

		Lecture202.addExit("east", new Exit("you see a lab with desktop computers to the east", Lab203));
		Lab203.addExit("west", new Exit("you see a lecutre hall to the west", Lecture202));

		Lecture202.addExit("northwest", new Exit("you see a library to the northwest", Library));
		Library.addExit("southeast", new Exit("you see a lecture hall to the southeast", Lecture202));

		Lecture202.addExit("northeast", new Exit("you see a lecture hall to the northeast", Lecture301));
		Lecture301.addExit("southwest", new Exit("you see a lecture hall to the southwest", Lecture202));

		Lab203.addExit("north", new Exit("you see a Lecture hall to the north", Lecture301));
		Lecture301.addExit("south", new Exit("you see a lab with desktop computers to the south", Lab203));

		StaffOffice.addExit("north", new Exit("you see a cafe at the north", Cafeteria));
		Cafeteria.addExit("south", new Exit("you see a office with cabins to the south", StaffOffice));

		StaffOffice.addExit("northeast", new Exit("you see a big office to the  northeast", ManagementOffice));
		ManagementOffice.addExit("southwest", new Exit("you see a office with cabins to the southwest", StaffOffice));

		Library.addExit("northwest", new Exit("you see a big office to the northwest", ManagementOffice));
		ManagementOffice.addExit("southeast", new Exit("you see a library to the southeast", Library));

		Library.addExit("northeast", new Exit("you see a table tennis room to the northeast", TableTennisRoom));
		TableTennisRoom.addExit("southwest", new Exit("you see a library to the southwest", Library));

		Lecture301.addExit("northwest", new Exit("you see a table tennis room to the north west", TableTennisRoom));
		TableTennisRoom.addExit("southeast", new Exit("you see a lecture hall to the south east", Lecture301));

		Lecture301.addExit("north", new Exit("you see a lab with desktop computers to the north", Lab401));
		Lab401.addExit("south", new Exit("you see a lecture hall to the south", Lecture301));

		Cafeteria.addExit("east", new Exit("you see a big office to the east", ManagementOffice));
		ManagementOffice.addExit("west", new Exit("you see a cafe to the west", Cafeteria));

		TableTennisRoom.addExit("east", new Exit("you see a lab with desktop computers to the east", Lab401));
		Lab401.addExit("west", new Exit("you see a table tennis room to the west", TableTennisRoom));

		// Adding NPCS to locations 
		Cafeteria.addNPC(new NonPlayerCharacter("Drago", true));//hostile characters
		Lecture301.addNPC(new NonPlayerCharacter("Ignil", true));
		Reception.addNPC(new NonPlayerCharacter("Ganesh"));
		ManagementOffice.addNPC(new NonPlayerCharacter("Sita"));

		// Adding free Items armor weapon shield anything in locations that is item
		Library.addItems(new Armor("Gladius", 120, 300, "This is an ancient gold armour.",4));
		Lab201.addItems(new Shield("IceCoffin", 139, 250, "This is a legendary ice shield.",6));
		Cafeteria.addItems(new Weapon("Lava", 156, 310, "This is a Lava breathing sword.",5));
		Blacksmith bs = new Blacksmith("Vergo");
		bs.getStorage().addMoney(5000);// giving initial money for blacksmith if some one sells an item he needs to give
										// money to player
		// Adding weapons to blacksmith's inventory
		bs.addItem(new Weapon("Kharas", 214, 600, "Very powerful hammer of mass destruction forged by Reorx.",7));
		bs.addItem(new Weapon("Excalibur", 193, 750, "Very powerful sword once owned by King Aurthur.",6));
		bs.addItem(new Weapon("Gladius", 300, 680, "Very powerful sword of Gladius.",5));
		bs.addItem(new Weapon("Thor", 400, 775, "Very powerful hammer once owned by god Thor.",4));
		bs.addItem(new Weapon("Light", 190, 500, "Very powerful arrow of lightning used by gods.",3));
		bs.addItem(new Weapon("Trident", 350, 800, "Very powerful sword once owned by King Aurthur.",2));

		// Adding shields to blacksmith's inventory
		bs.addItem(new Shield("LifeSaver", 270, 600, "Very powerful shield.",5));
		bs.addItem(new Shield("Protector", 280, 700, "Very powerful shield.",6));
		bs.addItem(new Shield("Lightoflife", 290, 800, "Very powerful shield.",4));
		bs.addItem(new Shield("Jiban", 302, 900, "Very powerful shield.",5));
		bs.addItem(new Shield("Swas", 205, 500, "Very powerful shield.",5));
		bs.addItem(new Shield("Surya", 200, 500, "Very powerful shield.",6));

		// Adding Armor to blacksmith's inventory
		bs.addItem(new Armor("GodsArmor", 180, 450, "Very powerful armor.",5));
		bs.addItem(new Armor("HellArmor", 300, 600, "Very powerful armor.",5));
		bs.addItem(new Armor("WaterWall", 350, 700, "Very powerful armor.",5));
		bs.addItem(new Armor("Pain", 180, 400, "Very powerful armor.",4));
		bs.addItem(new Armor("Exodus", 275, 600, "Very powerful armor.",6));

		Lab203.addNPC(bs);
		
		//Just to make it simple I am putting a copy of same blacksmith in every 
		//location but the item they sell and purchase will make every shops different
		StaffOffice.addNPC(bs);
		TableTennisRoom.addNPC(bs);
	}

	private void populateStrengthTable() {
		StrengthTable strengthModifiers = StrengthTable.getInstance();
		strengthModifiers.setModifier(1, -5);
		strengthModifiers.setModifier(2, -4);
		strengthModifiers.setModifier(3, -4);
		strengthModifiers.setModifier(4, -3);
		strengthModifiers.setModifier(5, -3);
		strengthModifiers.setModifier(6, -2);
		strengthModifiers.setModifier(7, -2);
		strengthModifiers.setModifier(8, -1);
		strengthModifiers.setModifier(9, -1);
		strengthModifiers.setModifier(10, 0);
		strengthModifiers.setModifier(11, 0);
		strengthModifiers.setModifier(12, 1);
		strengthModifiers.setModifier(13, 1);
		strengthModifiers.setModifier(14, 2);
		strengthModifiers.setModifier(15, 2);
		strengthModifiers.setModifier(16, 3);
		strengthModifiers.setModifier(17, 3);
		strengthModifiers.setModifier(18, 4);
		strengthModifiers.setModifier(19, 4);
		strengthModifiers.setModifier(20, 5);
		strengthModifiers.setModifier(21, 5);
		strengthModifiers.setModifier(22, 5);
		strengthModifiers.setModifier(23, 5);
		strengthModifiers.setModifier(24, 5);
		strengthModifiers.setModifier(25, 5);
		strengthModifiers.setModifier(26, 8);
		strengthModifiers.setModifier(27, 8);
		strengthModifiers.setModifier(28, 8);
		strengthModifiers.setModifier(29, 8);
		strengthModifiers.setModifier(30, 10);
		strengthModifiers.setModifier(31, 10);
		strengthModifiers.setModifier(32, 10);
		strengthModifiers.setModifier(33, 10);
		strengthModifiers.setModifier(34, 10);
		strengthModifiers.setModifier(35, 10);
		strengthModifiers.setModifier(36, 12);
		strengthModifiers.setModifier(37, 12);
		strengthModifiers.setModifier(38, 12);
		strengthModifiers.setModifier(39, 12);
		strengthModifiers.setModifier(40, 12);
		strengthModifiers.setModifier(41, 15);
		strengthModifiers.setModifier(42, 15);
		strengthModifiers.setModifier(43, 15);
		strengthModifiers.setModifier(44, 17);
		strengthModifiers.setModifier(45, 17);
		strengthModifiers.setModifier(46, 18);
	}

	private void populateAgilityTable() {
		AgilityTable agilityModifiers = AgilityTable.getInstance();
		agilityModifiers.setModifier(1, -5);
		agilityModifiers.setModifier(2, -5);
		agilityModifiers.setModifier(3, -5);
		agilityModifiers.setModifier(4, -3);
		agilityModifiers.setModifier(5, -3);
		agilityModifiers.setModifier(6, -2);
		agilityModifiers.setModifier(7, -2);
		agilityModifiers.setModifier(8, -1);
		agilityModifiers.setModifier(9, -1);
		agilityModifiers.setModifier(10, 0);
		agilityModifiers.setModifier(11, 0);
		agilityModifiers.setModifier(12, 1);
		agilityModifiers.setModifier(13, 1);
		agilityModifiers.setModifier(14, 2);
		agilityModifiers.setModifier(15, 2);
		agilityModifiers.setModifier(16, 3);
		agilityModifiers.setModifier(17, 3);
		agilityModifiers.setModifier(18, 4);
		agilityModifiers.setModifier(19, 4);
		agilityModifiers.setModifier(20, 6);
		agilityModifiers.setModifier(21, 6);
		agilityModifiers.setModifier(22, 6);
		agilityModifiers.setModifier(23, 6);
		agilityModifiers.setModifier(24, 6);
		agilityModifiers.setModifier(25, 6);
		agilityModifiers.setModifier(26, 8);
		agilityModifiers.setModifier(27, 8);
		agilityModifiers.setModifier(28, 8);
		agilityModifiers.setModifier(29, 8);
		agilityModifiers.setModifier(30, 8);
		agilityModifiers.setModifier(31, 8);
		agilityModifiers.setModifier(32, 11);
		agilityModifiers.setModifier(33, 11);
		agilityModifiers.setModifier(34, 11);
		agilityModifiers.setModifier(35, 11);
		agilityModifiers.setModifier(36, 11);
		agilityModifiers.setModifier(37, 11);
		agilityModifiers.setModifier(38, 13);
		agilityModifiers.setModifier(39, 13);
		agilityModifiers.setModifier(40, 13);
		agilityModifiers.setModifier(41, 13);
		agilityModifiers.setModifier(42, 13);
		agilityModifiers.setModifier(43, 13);
		agilityModifiers.setModifier(44, 15);
		agilityModifiers.setModifier(45, 15);
		agilityModifiers.setModifier(46, 15);
	}

	private void populateWeightLimitTable() {
		WeightLimit weightModifier = WeightLimit.getInstance();
		weightModifier.setModifier(1, 6);
		weightModifier.setModifier(2, 13);
		weightModifier.setModifier(3, 20);
		weightModifier.setModifier(4, 26);
		weightModifier.setModifier(5, 33);
		weightModifier.setModifier(6, 40);
		weightModifier.setModifier(7, 46);
		weightModifier.setModifier(8, 53);
		weightModifier.setModifier(9, 60);
		weightModifier.setModifier(10, 66);
		weightModifier.setModifier(11, 76);
		weightModifier.setModifier(12, 86);
		weightModifier.setModifier(13, 100);
		weightModifier.setModifier(14, 116);
		weightModifier.setModifier(15, 133);
		weightModifier.setModifier(16, 153);
		weightModifier.setModifier(17, 173);
		weightModifier.setModifier(18, 200);
		weightModifier.setModifier(19, 233);
		weightModifier.setModifier(20, 266);
		weightModifier.setModifier(21, 306);
		weightModifier.setModifier(22, 346);
		weightModifier.setModifier(23, 400);
		weightModifier.setModifier(24, 466);
		weightModifier.setModifier(25, 533);
		weightModifier.setModifier(26, 613);
		weightModifier.setModifier(27, 693);
		weightModifier.setModifier(28, 800);
		weightModifier.setModifier(29, 933);
		weightModifier.setModifier(30, 1013);
		weightModifier.setModifier(31, 1093);
		weightModifier.setModifier(32, 1300);
		weightModifier.setModifier(33, 1433);
		weightModifier.setModifier(34, 1513);
		weightModifier.setModifier(35, 1593);
		weightModifier.setModifier(36, 1700);
		weightModifier.setModifier(37, 1833);
		weightModifier.setModifier(38, 1913);
		weightModifier.setModifier(39, 1993);
		weightModifier.setModifier(40, 2100);
		weightModifier.setModifier(41, 2233);
		weightModifier.setModifier(42, 2313);
		weightModifier.setModifier(43, 2393);
		weightModifier.setModifier(44, 2500);
		weightModifier.setModifier(45, 2633);
		weightModifier.setModifier(46, 2713);
	}

}
