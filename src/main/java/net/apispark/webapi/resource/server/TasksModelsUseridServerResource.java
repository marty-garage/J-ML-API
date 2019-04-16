package net.apispark.webapi.resource.server;

import java.io.File;
import java.net.URL;
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
import org.eclipse.jetty.util.log.Log;
import org.encog.ml.data.versatile.VersatileMLDataSet;
import org.encog.ml.data.versatile.columns.ColumnDefinition;
import org.encog.ml.data.versatile.columns.ColumnType;
import org.encog.ml.data.versatile.sources.CSVDataSource;
import org.encog.ml.data.versatile.sources.VersatileDataSource;
import org.encog.neural.neat.NEATNetwork;
import org.encog.util.csv.CSVFormat;
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

import ml_models.ML_Model;
import ml_models.ModelsFactory;

import java.util.logging.Level;

import net.apispark.webapi.representation.Usemodel;
import net.apispark.webapi.resource.TasksModelsUseridResource;
import net.apispark.webapi.utils.QueryParameterUtils;
import net.apispark.webapi.utils.PathVariableUtils;

public class TasksModelsUseridServerResource extends AbstractServerResource implements TasksModelsUseridResource {

    // Define allowed roles for the method "get".
    private static final String[] get2AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "get".
    private static final String[] get2DeniedGroups = new String[] {};

    public net.apispark.webapi.representation.Createmodel represent() throws Exception {
       net.apispark.webapi.representation.Createmodel result = null;
        checkGroups(get2AllowedGroups, get2DeniedGroups);
        

        try {
		
			// Path variables
			
	    String useridPathVariable = Reference.decode(getAttribute("userid"));
	    getLogger().log(Level.INFO, "request from user"+useridPathVariable);
	    
        // Query parameters
        
        	
	    result = new net.apispark.webapi.representation.Createmodel();
	    
	    // Initialize here your bean
         } catch (Exception ex) {
            // In a real code, customize handling for each type of exception
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }
    
        return result;
    }

    // Define allowed roles for the method "post".
    private static final String[] post3AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "post".
    private static final String[] post3DeniedGroups = new String[] {};

    public List<net.apispark.webapi.representation.Usemodel> add(net.apispark.webapi.representation.Createmodel bean) throws Exception {
       List<Usemodel> result = null;
        checkGroups(post3AllowedGroups, post3DeniedGroups);
        
    	if (bean==null) {
    		throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST);
    	}

        try {
		
			// Path variables
			
	    String useridPathVariable = Reference.decode(getAttribute("userid"));

        // Query parameters
        
        	
	    try {
			
	        // Query parameters
	        
	        	URL url = Thread.currentThread().getContextClassLoader()
	  				  .getResource("neat/solar2.txt");
	  		File filename = new File(url.getFile());
	  		   
	  	    	CSVFormat format = new CSVFormat ( '.' ,' ') ; 
	  	    	VersatileDataSource source = new CSVDataSource(filename , true ,format) ;
	  	    	VersatileMLDataSet data = new VersatileMLDataSet(source) ;
	  	    	data.getNormHelper().setFormat(format) ;
	  	    	ColumnDefinition columnSSN = data.defineSourceColumn("SSN", ColumnType.continuous) ;
	  	    	data.defineSourceColumn( "DEV" , ColumnType.continuous) ;
	  	    	data.defineSourceColumn("MON",ColumnType.continuous);
	  	    	data.defineSingleOutputOthersInput(columnSSN);
	  	    	
	  	    	ModelsFactory<?> factory = new ModelsFactory();
	  	    	
	  	    	
	  	    	ML_Model my_model = null;
	  	    	try {
	  				my_model = factory.getModel(Class.forName("ml_models.Neat_model"),data);
	  			} catch (InstantiationException | ClassNotFoundException e) {
	  				// TODO Auto-generated catch block
	  				e.printStackTrace();
	  			}	
		    result.add( new net.apispark.webapi.representation.Usemodel<ML_Model,NEATNetwork>(my_model));
		    
		    // Initialize here your bean
	         } catch (Exception ex) {
	            // In a real code, customize handling for each type of exception
	            getLogger().log(Level.WARNING, "Error when executing the method", ex);
	            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
	                    ex.getMessage(), ex);
	        }
	    
	        return result;
	    
	    // Initialize here your bean
         } catch (Exception ex) {
            // In a real code, customize handling for each type of exception
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }
    }

    // Define allowed roles for the method "delete".
    private static final String[] delete4AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "delete".
    private static final String[] delete4DeniedGroups = new String[] {};

    public net.apispark.webapi.representation.AnonymousRepresentation2 remove() throws Exception {
       net.apispark.webapi.representation.AnonymousRepresentation2 result = null;
        checkGroups(delete4AllowedGroups, delete4DeniedGroups);
        

        try {
		
			// Path variables
			
	    String useridPathVariable = Reference.decode(getAttribute("userid"));

        // Query parameters
        
        	
	    result = new net.apispark.webapi.representation.AnonymousRepresentation2();
	    
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

