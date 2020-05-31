package tests;



import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import mazegame.entity.Armor;

/**
 * @author RanaShahzad
 *
 */
public class ArmorTest extends TestCase {
	
	Armor armor;
	Armor armor2;
	
	
	
	public ArmorTest(String name) {
		super(name);
	}
	
	@Before
	protected void setUp() throws Exception{
		armor = new Armor("diamondarmor",300,600,"Hardest armor ever.",6);
		armor2 = new Armor("diamondarmor2",400,700,"Hardest armor ever2.",7);
		super.setUp();
	}
	
	
	
	@Test
	public void testGetProtection() {
		int expected=6;
		int expected2=7;
		assertEquals(expected, armor.getProtection());
		assertEquals(expected2, armor2.getProtection());
	}

	@Test
	public void testSetProtection() {
		int Protection = 9;
		int Protection2 = 10;
		armor.setProtection(9);
		armor2.setProtection(10);
		assertEquals(Protection, armor.getProtection());
		assertEquals(Protection2, armor2.getProtection());
	}
	
	@Test
	public void testGetName() {
		String expected="diamondarmor";
		String expected2="diamondarmor2";
		assertEquals(expected, armor.getName());
		assertEquals(expected2, armor2.getName());
	}
	
	@Test
	public void testSetName() {
		String name = "woodarmor";
		String name2 = "woodarmor2";
		armor.setName(name);
		armor2.setName(name2);
		assertEquals(name, armor.getName());
		assertEquals(name2, armor2.getName());
	}
	@Test
	public void testGetPrice() {
		int expected=300;
		int expected2=400;
		assertEquals(expected, armor.getPrice());
		assertEquals(expected2, armor2.getPrice());
	}

	@Test
	public void testSetPrice() {
		int Price =250;
		armor.setPrice(250);
		assertEquals(Price, armor.getPrice());
		int Price2 =251;
		armor2.setPrice(251);
		assertEquals(Price2, armor2.getPrice());
	}
	
	@Test
	public void testGetWeight() {
		double expected=600;
		assertEquals(expected, armor.getWeight());
		double expected2=700;
		assertEquals(expected2, armor2.getWeight());
	}

	@Test
	public void testSetWeight() {
		double Weight = 500;
		armor.setWeight(500);
		assertEquals(Weight, armor.getWeight());
		double Weight2 = 502;
		armor2.setWeight(502);
		assertEquals(Weight2, armor2.getWeight());
	}
	
	@Test
	public void testGetDescription() {
		String expected="Hardest armor ever.";
		assertEquals(expected, armor.getDescription());
		String expected2="Hardest armor ever2.";
		assertEquals(expected2, armor2.getDescription());
	}

	@Test
	public void testSetDescription() {
		String Description = "Very strong wooden armor.";
		armor.setDescription("Very strong wooden armor.");
		assertEquals(Description, armor.getDescription());
		String Description2 = "Very strong wooden armor2.";
		armor2.setDescription("Very strong wooden armor2.");
		assertEquals(Description2, armor2.getDescription());
	}
	
	

}
