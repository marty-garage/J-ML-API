
/**
 * factory for all computational possible models 
 */
package ml_models;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.net.URL;

import org.encog.ml.data.versatile.VersatileMLDataSet;
import org.encog.ml.data.versatile.columns.ColumnDefinition;
import org.encog.ml.data.versatile.columns.ColumnType;
import org.encog.ml.data.versatile.sources.CSVDataSource;
import org.encog.ml.data.versatile.sources.VersatileDataSource;
import org.encog.ml.model.EncogModel;
import org.encog.util.csv.CSVFormat;

/**
 * @author marty
 *
 */
public class ModelsFactory <T extends ML_Model>{

	public ML_Model getModel(Type modelType) throws InstantiationException{
		ML_Model instance;  
		if(modelType == null){
			throw new InstantiationException("no model type provided");
		}		

		try {
			instance = (T)Class.forName(modelType.getClass().getSimpleName()).newInstance();
		} catch (IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InstantiationException("model instatation failed");
		}
		return instance;
	   }
	
	public ML_Model getModel(Type modelType,T model) throws InstantiationException{
		ML_Model instance;  
		if(modelType == null){
			throw new InstantiationException("no model type provided");
		}	
		if(model != null) {
			
			try {
				Constructor<?> costructor;
				costructor = Class.forName(modelType.getClass().getSimpleName()).getConstructor(new Class[]{ML_Model.class});
				instance = (ML_Model) costructor.newInstance(model);
				this.SetUpInstance(instance);
			} catch (NoSuchMethodException | SecurityException | 
						ClassNotFoundException | InvocationTargetException | 
						IllegalAccessException | IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new InstantiationException("model instatation failed");
			}
			
		}

		try {
			instance = (T)Class.forName(modelType.getClass().getSimpleName()).newInstance();
			this.SetUpInstance(instance);
		} catch (IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InstantiationException("model instatation failed");
		}
		return instance;
	   }
	
	
	
	
	private void SetUpInstance(ML_Model model) {
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
	    	
	    	
	    	model.set_model(new EncogModel(model.get_data()));;
	    	
	}
}
