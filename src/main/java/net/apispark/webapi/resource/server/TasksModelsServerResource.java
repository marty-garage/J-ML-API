package net.apispark.webapi.resource.server;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.restlet.data.Reference;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.data.Preference;
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
import ml_models.ModelsDenomination;
import ml_models.ModelsFactory;

import java.util.logging.Level;

import net.apispark.webapi.representation.Usemodel;
import net.apispark.webapi.resource.TasksModelsResource;
import net.apispark.webapi.utils.QueryParameterUtils;
import net.apispark.webapi.utils.PathVariableUtils;

public class TasksModelsServerResource extends AbstractServerResource implements TasksModelsResource {

    // Define allowed roles for the method "get".
    private static final String[] get1AllowedGroups = new String[] {"anyone"};
    // Define denied roles for the method "get".
    private static final String[] get1DeniedGroups = new String[] {};

    public List<ml_models.ModelsDenomination> represent() throws Exception {
       ArrayList<ModelsDenomination> result = new ArrayList<ModelsDenomination>() ;
        checkGroups(get1AllowedGroups, get1DeniedGroups);
        
       
        result.addAll(Arrays.asList(ModelsDenomination.values()));
     

        try {
		
        /*        
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
	     * 
	     */
         } catch (Exception ex) {
            // In a real code, customize handling for each type of exception
            getLogger().log(Level.WARNING, "Error when executing the method", ex);
            throw new ResourceException(Status.SERVER_ERROR_INTERNAL,
                    ex.getMessage(), ex);
        }
    
        return result;
    }


}

