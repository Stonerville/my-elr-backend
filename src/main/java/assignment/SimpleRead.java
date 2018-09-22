package assignment;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.model.ResourceType;
import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.gclient.TokenClientParam;
import ca.uhn.fhir.rest.gclient.StringClientParam
import ca.uhn.fhir.rest.gclient.ICriterion;

/**
 * This class contains methods for reading resources from the FHIR server.
 */
public class SimpleRead {

    IGenericClient client = null;

    public SimpleRead(String baseUrl) {
        FhirContext ctx = FhirContext.forDstu3();
        client = ctx.newRestfulGenericClient(baseUrl);
    }

    /**
     * Find the patient with the given ID and return the full name as a
     * single string.
     */
    public String getNameByPatientID(String id) {
        // Hint, there is a method that will return the full name including
        // prefix, first, last, and suffix
        //Place your code here
        String returnId = "";
        id = StringUtils.isEmpty(id) ? "" :id;
        Bundle bundle = retrieveBundle(new TokenClientParam("_id").exactly().code(id));
        if (null!=bundle && null!=bundle.getEntryFirstRep() && null!=bundle.getEntryFirstRep().getResource()){
            Resource resource = bundle.getEntryFirstRep().getResource();
            Patient patient = null;
            if (null!=resource.getResourceType() && ResourceType.Patient==resource.getResourceType()){
                patient = (Patient)resource;               
                returnId = patient.getName().get(0).getNameAsSingleString();
            }
        }
    return returnId;
        //just so it will compile, return nothing
    }

    /**
     * Find all the patients that have the provided name and return a list
     * of the IDs for those patients.  The search should include matches
     * where any part of the patient name (family, given, prefix, etc.)
     * matches the method 'name' parameter.
     */
    public List<String> getIDByPatientName(String name) {
        //Place your code here
        List<String> patients = new ArrayList<String>();
        name = StringUtils.isEmpty(name) ? "" :name;
        Bundle bundle = retrieveBundle(new StringClientParam("name").matches().value(name));
        // if (null!=bundle && null!=bundle.getEntryFirstRep(){
        //     Resource resource = bundle.getResource();
        //     Patient patient = null;
        //     if (null!=resource.getResourceType() && ResourceType.Patient==resource.getResourceType()){
        //         patient = (Patient)resource.;               
        //         returnId = patient.getName().get(0).getNameAsSingleString();
        //     }
        // }
        patients = bundle.getEntryFirstRep();
        return patients;
        // return new ArrayList<String>();//just so it will compile, return nothing
    }

    private Bundle retrieveBundle(ICriterion<?> clientParam){
        return (Bundle) client.search().forResource(Patient.class)
                .where(clientParam).encodedJson().execute();
    }

}