
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
 *
 */


public class ModelsFactory <T extends ML_Model>{

	public  ML_Model getModel(Type modelType) throws InstantiationException{
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
	
	public  ML_Model getModel(Type modelType,VersatileMLDataSet data) throws InstantiationException{
		ML_Model instance;  
		if(modelType == null){
			throw new InstantiationException("no model type provided");
		}		

		try {
			Constructor<?> costructor;
			costructor = Class.forName(modelType.getTypeName()).getConstructor(new Class[]{VersatileMLDataSet.class});
			instance = (ML_Model) costructor.newInstance(data);
		} catch (ReflectiveOperationException | RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InstantiationException("model instatation failed");
		}
		return instance;
	   }
	public  ML_Model getModel(Type modelType,T model) throws InstantiationException{
		ML_Model instance;  
		if(modelType == null){
			throw new InstantiationException("no model type provided");
		}	
		if(model != null) {
			
			try {
				Constructor<?> costructor;
				costructor = Class.forName(modelType.getClass().getSimpleName()).getConstructor(new Class[]{ML_Model.class});
				instance = (ML_Model) costructor.newInstance(model);
				SetUpInstance(instance);
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
			SetUpInstance(instance);
		} catch (IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InstantiationException("model instatation failed");
		}
		return instance;
	   }
	
	
	
	
	private static void SetUpInstance(ML_Model model) {
		
		
		if(model.get_data()!= null) {
			model.set_model(new EncogModel(model.get_data())); //TODO: move to factory
		}else {
			//EncogModel model = new EncogModel();
		}
		
		
	    	//model.set_model(new EncogModel(model.get_data()));;
	    	
	}

}
