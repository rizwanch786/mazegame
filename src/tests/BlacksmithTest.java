package tests;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import mazegame.entity.Blacksmith;
import mazegame.entity.Item;
import mazegame.entity.Weapon;

/**
 * @author SagarShrestha
 *
 */
public class BlacksmithTest extends TestCase {

	
	Blacksmith blacksmith;
	Blacksmith blacksmith2;
	
	public BlacksmithTest(String name) {
		super(name);
	}
	
	@Before
	protected void setUp() throws Exception{
		blacksmith = new Blacksmith("Tenten");
		blacksmith2 = new Blacksmith("Tenten2");
		super.setUp();
	}
	
	@Test
	public void testAddItem() {
		Item item = new Weapon("WhiteDaggar",240,450,"Ancient Daggar of spirit.",7);
		Item item2 = new Weapon("WhiteDaggar2",242,452,"Ancient Daggar of spirit2.",8);
		blacksmith.addItem(item);
		blacksmith2.addItem(item2);
		assertEquals(item, blacksmith.getStorage().getItemList().get(("whitedaggar")));
		//the name is changed to lower case so using lowecase to get the item 
		assertEquals(item2, blacksmith2.getStorage().getItemList().get(("whitedaggar2")));
	}

	
}
