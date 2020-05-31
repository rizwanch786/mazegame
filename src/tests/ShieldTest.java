package tests;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import mazegame.entity.Shield;

/**
 * @author SagarShrestha
 *
 */
public class ShieldTest extends TestCase {

	Shield shield;
	Shield shield2;
	
	public ShieldTest(String name) {
		super(name);
	}
	
	@Before
	public void setUp() throws Exception{
		shield= new Shield("diamondshield",300,600,"Hardest shield ever.",6);
		shield2= new Shield("diamondshield2",301,601,"Hardest shield ever2.",7);
		super.setUp();
	}
	
	@Test
	public void testGetProtection() {
		int expected=6;
		assertEquals(expected, shield.getProtection());
		int expected2=7;
		assertEquals(expected2, shield2.getProtection());
	}

	@Test
	public void testSetProtection() {
		int Protection = 9;
		shield.setProtection(9);
		assertEquals(Protection, shield.getProtection());
		int Protection2 = 10;
		shield2.setProtection(10);
		assertEquals(Protection2, shield2.getProtection());
	}
	
	@Test
	public void testGetName() {
		String expected="diamondshield";
		assertEquals(expected, shield.getName());
		String expected2="diamondshield2";
		assertEquals(expected2, shield2.getName());
	}

	@Test
	public void testSetName() {
		String name = "woodenshield";
		shield.setName(name);
		assertEquals(name, shield.getName());
		String name2 = "woodenshield2";
		shield2.setName(name2);
		assertEquals(name2, shield2.getName());
	}
	
	@Test
	public void testGetPrice() {
		int expected=300;
		assertEquals(expected, shield.getPrice());
		int expected2=301;
		assertEquals(expected2, shield2.getPrice());
	}

	@Test
	public void testSetPrice() {
		int Price =250;
		shield.setPrice(250);
		assertEquals(Price, shield.getPrice());
		int Price2 =251;
		shield2.setPrice(251);
		assertEquals(Price2, shield2.getPrice());
	}
	
	@Test
	public void testGetWeight() {
		double expected=600;
		assertEquals(expected, shield.getWeight());
		double expected2=601;
		assertEquals(expected2, shield2.getWeight());
	}

	@Test
	public void testSetWeight() {
		double Weight = 500;
		shield.setWeight(500);
		assertEquals(Weight, shield.getWeight());
		double Weight2 = 501;
		shield2.setWeight(501);
		assertEquals(Weight2, shield2.getWeight());
	}
	
	@Test
	public void testGetDescription() {
		String expected="Hardest shield ever.";
		assertEquals(expected, shield.getDescription());
		String expected2="Hardest shield ever2.";
		assertEquals(expected2, shield2.getDescription());
	}

	@Test
	public void testSetDescription() {
		String Description = "Very strong wooden shield.";
		shield.setDescription("Very strong wooden shield.");
		assertEquals(Description, shield.getDescription());
		String Description2 = "Very strong wooden shield2.";
		shield2.setDescription("Very strong wooden shield2.");
		assertEquals(Description2, shield2.getDescription());
	}
	
	
}
