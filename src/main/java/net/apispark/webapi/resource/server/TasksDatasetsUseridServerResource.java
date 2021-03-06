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

import net.apispark.webapi.resource.TasksDatasetsUseridResource;
import net.apispark.webapi.utils.QueryParameterUtils;
import net.apispark.webapi.utils.PathVariableUtils;

public class TasksDatasetsUseridServerResource extends AbstractServerResource implements TasksDatasetsUseridResource {

    // Define allowed roles for the method "post".
    private static final String[] post5AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "post".
    private static final String[] post5DeniedGroups = new String[] {};

    public net.apispark.webapi.representation.AnonymousRepresentation3 add(net.apispark.webapi.representation.UploadDataset bean) throws Exception {
       net.apispark.webapi.representation.AnonymousRepresentation3 result = null;
        checkGroups(post5AllowedGroups, post5DeniedGroups);
        
    	if (bean==null) {
    		throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);
    	}

        try {
		
			// Path variables
			
	    String useridPathVariable = Reference.decode(getAttribute("userid"));

        // Query parameters
        
        	
	    result = new net.apispark.webapi.representation.AnonymousRepresentation3();
	    
	    // Initialize here your bean
         } catch (Exception ex) {
            // In a real code, customize handling for each type of exception
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }
    
        return result;
    }

    // Define allowed roles for the method "delete".
    private static final String[] delete6AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "delete".
    private static final String[] delete6DeniedGroups = new String[] {};

    public void remove() throws Exception {
        checkGroups(delete6AllowedGroups, delete6DeniedGroups);
        

        try {
         } catch (Exception ex) {
            // In a real code, customize handling for each type of exception
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }
    
        
    }

    // Define allowed roles for the method "get".
    private static final String[] get7AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "get".
    private static final String[] get7DeniedGroups = new String[] {};

    public net.apispark.webapi.representation.UploadDataset represent() throws Exception {
       net.apispark.webapi.representation.UploadDataset result = null;
        checkGroups(get7AllowedGroups, get7DeniedGroups);
        

        try {
		
			// Path variables
			
	    String useridPathVariable = Reference.decode(getAttribute("userid"));

        // Query parameters
        
        	
	    result = null;//TODO: add the dao retrive new net.apispark.webapi.representation.UploadDataset();
	    
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

