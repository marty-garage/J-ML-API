package ml_models;

import org.encog.ml.factory.MLMethodFactory;
import org.encog.ml.model.EncogModel;
import org.encog.neural.neat.NEATNetwork;

public class Neat_model extends ML_Model {

	public Neat_model() {
		if(super.get_data()!= null) {
			super.set_model(new EncogModel(super.get_data())); //TODO: move to factory
		}else {
			//EncogModel model = new EncogModel();
		}
		super.setType(MLMethodFactory.TYPE_NEAT);
	}

	@Override
	public NEATNetwork Train() {
		// TODO Auto-generated method stub
		return null;
	}

}
