
/**
 * factory for all computational possible models 
 */
package ml_models;

import java.lang.reflect.Type;

/**
 * @author marty
 *
 */
public class ModelsFactory <T extends ML_Model>{

	public ML_Model getShape(Type modelType) throws InstantiationException{
	      if(modelType == null){
	         throw new InstantiationException("no model type provided");
	      }		
	      
	      try {
			ML_Model instance = (T)Class.forName(modelType.getClass().getSimpleName()).newInstance();
		} catch (IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InstantiationException("model instatation failed");
		}
	      return null;
	   }
}
