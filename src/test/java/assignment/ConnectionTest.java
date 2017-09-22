package assignment;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Connection.
 */
public class ConnectionTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ConnectionTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ConnectionTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testConnection() {
        String serverBase = "http://fhirtest.uhn.ca/baseDstu2";
        Connection conn = new Connection(serverBase);
        //do something with the connection to make sure it works...
        fail("no tests");
    }
}
