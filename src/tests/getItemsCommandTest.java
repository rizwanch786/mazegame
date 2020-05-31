package tests;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import mazegame.HardCodedData;
import mazegame.control.*;
import mazegame.entity.*;

/**
 * @author RanaShahzad
 *
 */
public class getItemsCommandTest extends TestCase {
	Location location;
	Player player1;
	ParsedInput user = new ParsedInput();
	getItemsCommand get= new getItemsCommand();
	HardCodedData hd= new HardCodedData();
	
	public getItemsCommandTest(String name) {
		super(name);
	}

	@Before
	protected void setUp() throws Exception {
		
		location = new Location("You see empty hall with some couch and some people", "Entrance Lobby");
		location.addItems(new Armor("gladius", 120, 300, "This is an ancient gold armour.", 4));
		player1= new Player("Ban");
		player1.getInventory().addMoney(500);
		player1.setCurrentLocation(location);
		ArrayList<String> argumet= new ArrayList<String>();
		argumet.add("gladius");
		user.setArguments(argumet);
		super.setUp();
	}

	@Test
	public void testExecute() {
		CommandResponse cr= get.execute(user, player1);
		assertEquals(("You have successfully picked the gladius\nHello BAN,\nYour current Status is: \nYou "
				+ "have agility: 35\nYou have lifepoint: 35\nYou have strength: 35\n"
				+ "Your weight Limit is: 1593.0\nYour party is: Default Dungueon Party\nThere are 500 gold pieces\nYour total item weight is: 305.0\n"),cr.getMessage());
	}

}
