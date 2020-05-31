package tests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author RanaShahzad
 *
 */
public class AllTests extends TestCase {
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for mazegame.tests");
		//$JUnit-BEGIN$
				suite.addTestSuite(ArmorTest.class);
				suite.addTestSuite(WeaponTest.class);
				suite.addTestSuite(BlacksmithTest.class);
				suite.addTestSuite(getItemsCommandTest.class);
				suite.addTestSuite(ShieldTest.class);
				//$JUnit-END$
				return suite;
	}
}
