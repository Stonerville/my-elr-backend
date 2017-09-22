package assignment;

import java.util.List;
import java.util.ArrayList;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;

/**
 *
 */
public class SimpleRead {

    //This Connection object is the same as the one you implemented in the first FHIR task
    private Connection connection = null;

    public SimpleRead(Connection connection) {
        this.connection = connection;
    }

    public String getNameByPatientID(String id) {
        //Place your code here
    		return "";
    }

    public List<String> getIDByPatientName(String name) {
        List<String> answer = new ArrayList<String>();
        //Place your code here
        return answer;
    }

}