
/**
 * factory for all computational possible models 
 */
package ml_models;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

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
			} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | InvocationTargetException | IllegalAccessException | IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
}
