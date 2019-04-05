package net.apispark.webapi.resource.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.restlet.data.Reference;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.data.Preference;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.representation.ObjectRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.restlet.util.Series;
import java.util.logging.Level;

import net.apispark.webapi.resource.TasksModelsResource;
import net.apispark.webapi.utils.QueryParameterUtils;
import net.apispark.webapi.utils.PathVariableUtils;

public class TasksModelsServerResource extends AbstractServerResource implements TasksModelsResource {

    // Define allowed roles for the method "get".
    private static final String[] get1AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "get".
    private static final String[] get1DeniedGroups = new String[] {};

    public List<net.apispark.webapi.representation.Createmodel> represent() throws Exception {
       ArrayList<net.apispark.webapi.representation.Createmodel> result = new ArrayList<net.apispark.webapi.representation.Createmodel>() ;
        checkGroups(get1AllowedGroups, get1DeniedGroups);
        

        try {
		
        // Query parameters
        
        	
	    result.add( new net.apispark.webapi.representation.Createmodel());
	    
	    // Initialize here your bean
         } catch (Exception ex) {
            // In a real code, customize handling for each type of exception
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }
    
        return result;
    }


}

