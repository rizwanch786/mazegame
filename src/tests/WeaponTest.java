package tests;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import mazegame.entity.Shield;
import mazegame.entity.Weapon;

/**
 * @author RanaShahzad
 *
 */
public class WeaponTest extends TestCase {

	Weapon weapon;
	Weapon weapon2;
	
	public WeaponTest(String name) {
		super(name);
	}
	
	@Before
	public void setUp() throws Exception{
		weapon= new Weapon("diamondDaggar",300,600,"Sharpest dagger ever.",6);
		weapon2= new Weapon("diamondDaggar2",301,601,"Sharpest dagger ever2.",7);
		super.setUp();
	}
	
	@Test
	public void testGetCombatPower() {
		int expected=6;
		assertEquals(expected, weapon.getCombatPower());
		int expected2=7;
		assertEquals(expected2, weapon2.getCombatPower());
	}

	@Test
	public void testSetCombatPower() {
		int combatpower = 9;
		weapon.setCombatPower(9);
		assertEquals(combatpower, weapon.getCombatPower());
		int combatpower2 = 10;
		weapon2.setCombatPower(10);
		assertEquals(combatpower2, weapon2.getCombatPower());
	}
	
	@Test
	public void testGetName() {
		String expected="diamondDaggar";
		assertEquals(expected.toLowerCase(), weapon.getName());
		String expected2="diamondDaggar2";
		assertEquals(expected2.toLowerCase(), weapon2.getName());
	}

	@Test
	public void testSetName() {
		String name = "woodenDaggar";
		weapon.setName(name);
		assertEquals(name, weapon.getName());
		String name2 = "woodenDaggar2";
		weapon2.setName(name2);
		assertEquals(name2, weapon2.getName());
	}
	
	@Test
	public void testGetPrice() {
		int expected=300;
		assertEquals(expected, weapon.getPrice());
		int expected2=301;
		assertEquals(expected2, weapon2.getPrice());
	}

	@Test
	public void testSetPrice() {
		int Price =250;
		weapon.setPrice(250);
		assertEquals(Price, weapon.getPrice());
		int Price2 =251;
		weapon2.setPrice(251);
		assertEquals(Price2, weapon2.getPrice());
	}
	
	@Test
	public void testGetWeight() {
		double expected=600;
		assertEquals(expected, weapon.getWeight());
		double expected2=601;
		assertEquals(expected2, weapon2.getWeight());
	}
	
	@Test
	public void testSetWeight() {
		double Weight = 500;
		weapon.setWeight(500);
		assertEquals(Weight, weapon.getWeight());
		double Weight2 = 501;
		weapon2.setWeight(501);
		assertEquals(Weight2, weapon2.getWeight());
	}
	
	@Test
	public void testGetDescription() {
		String expected="Sharpest dagger ever.";
		assertEquals(expected, weapon.getDescription());
		String expected2="Sharpest dagger ever2.";
		assertEquals(expected2, weapon2.getDescription());
	}

	@Test
	public void testSetDescription() {
		String Description = "Very strong iron dagger.";
		weapon.setDescription("Very strong iron dagger.");
		assertEquals(Description, weapon.getDescription());
		String Description2 = "Very strong iron dagger2.";
		weapon2.setDescription("Very strong iron dagger2.");
		assertEquals(Description2, weapon2.getDescription());
	}
	

}
