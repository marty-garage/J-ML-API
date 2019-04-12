package ml_models;

import org.encog.ConsoleStatusReportable;
import org.encog.ml.data.versatile.VersatileMLDataSet;
import org.encog.ml.factory.MLMethodFactory;
import org.encog.ml.model.EncogModel;

public class FF_model extends ML_Model {

	public FF_model(VersatileMLDataSet dataset) {
		super.set_data(dataset);
		super.set_model(new EncogModel(super.get_data()));
		VersatileMLDataSet data = super.get_data(); 
		super.setType(MLMethodFactory.TYPE_FEEDFORWARD);
		// Send any output to the console.
		super.get_model().setReport(new ConsoleStatusReportable () ) ;
		// Now normalize the data. Encog will automatically // determine the correct normalization type based
		// on the model you chose in the last step.
		data.normalize() ;
		data.setLagWindowSize(90);
		data.setLeadWindowSize(4);
 	
		super.get_model().holdBackValidation(0.3, false, 1001);
		super.get_model().selectTrainingType(data) ;
		// Use a 5−fold cross−validated train . Return the best
	}

	@Override
	public Object Train() {
		// TODO Auto-generated method stub
		return null;
	}

}
