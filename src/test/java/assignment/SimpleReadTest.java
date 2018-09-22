package assignment;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Connection.
 */
public class SimpleReadTest extends TestCase {
    static final String serverBase ="http://hapi.fhir.org/baseDstu3";
    static final SimpleRead reader = new SimpleRead(serverBase);
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SimpleReadTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SimpleReadTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testGetNameByPatientID() {
        //do something with the reader to make sure it works...
        String patientID = "1232181";//find a good patient
        String expected_name = "Alexander Johnson";
        String actual_name = reader.getNameByPatientID(patientID);
        // System.out.println("\n*********************************************\n");
        // System.out.println("patientID: "+patientID);
        // System.out.println("\n*********************************************\n");
        assertEquals(expected_name, actual_name);
    }
    // public void testGetIDByPatientName() {
    //     //do something with the reader to make sure it works...
    //     String patientName = "Smith";//find a good patient
    //     int expected_count = 3;
    //     String actual_name = reader.getIDByPatientName();
    //     // System.out.println("\n*********************************************\n");
    //     // System.out.println("patientID: "+patientID);
    //     // System.out.println("\n*********************************************\n");
    //     assertEquals(expected_name, actual_name);
    // }
}
