package ml_models;

import java.io.Serializable;

import org.encog.ConsoleStatusReportable;
import org.encog.ml.MLRegression;
import org.encog.ml.data.versatile.VersatileMLDataSet;
import org.encog.ml.factory.MLMethodFactory;
import org.encog.ml.model.EncogModel;

public class FF_model extends ML_Model<MLRegression> implements Serializable{

	public FF_model(VersatileMLDataSet dataset) {
		super.set_data(dataset);
		super.set_model(new EncogModel(super.get_data()));
		VersatileMLDataSet data = super.get_model().getDataset();
		data.analyze();
		super.setType(MLMethodFactory.TYPE_FEEDFORWARD);
		// Send any output to the console.
		//super.get_model().setReport(new ConsoleStatusReportable () ) ;
		// Now normalize the data. Encog will automatically // determine the correct normalization type based
		// on the model you chose in the last step.
		data.normalize() ;
		data.setLagWindowSize(90);
		data.setLeadWindowSize(1);
		super.set_data(dataset);
		super.get_model().holdBackValidation(0.3, false, 1001);
		super.get_model().selectTrainingType(super.get_data()) ;
		// Use a 5−fold cross−validated train . Return the best
	}

	@Override
	public MLRegression Train() {
		// TODO Auto-generated method stub
				MLRegression bestMethod =
				(MLRegression)super.get_model().crossvalidate(5, true);
		return bestMethod;
	}

}
