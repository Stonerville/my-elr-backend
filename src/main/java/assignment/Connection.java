package assignment;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.IGenericClient;

/**
 *
 */
public class Connection {

    private IGenericClient client = null;

    public Connection(String baseUrl) {
        //Place your code here
    }

    public IGenericClient getClient() {
        return client;
    }

}
