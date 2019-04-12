package ml_models;

import org.encog.ml.CalculateScore;
import org.encog.ml.data.versatile.VersatileMLDataSet;
import org.encog.ml.factory.MLMethodFactory;
import org.encog.ml.model.EncogModel;
import org.encog.neural.neat.NEATNetwork;
import org.encog.neural.neat.NEATPopulation;
import org.encog.neural.neat.NEATUtil;
import org.encog.neural.networks.training.TrainingSetScore;

public class Neat_model extends ML_Model {
	private NEATPopulation _pop;

	public Neat_model(VersatileMLDataSet dataset) {
		
		super.set_data(dataset);
		super.set_model(new EncogModel(super.get_data()));
		VersatileMLDataSet data = super.get_data(); //TODO does not exist
		super.setType(MLMethodFactory.TYPE_NEAT);
		data.analyze();
		data.normalize();
		data.setLagWindowSize(90);
		data.setLeadWindowSize(4);
 	
		super.get_model().holdBackValidation(0.3, false, 75);
 	
 	//------------------------------------------------
		_pop = new NEATPopulation(30,4,1000);
		_pop.setInitialConnectionDensity(1.0);// not required, but speeds training
		_pop.reset();	
		//EncogUtility.trainToError(train, error);
	
		CalculateScore score = new TrainingSetScore(data);
 	
		
		
		super.set_train(NEATUtil.constructNEATTrainer(_pop, score));
	}

	@Override
	public NEATNetwork Train() {
		do {
			super.get_train().iteration();
			System.out.println("Epoch #" + super.get_train().getIteration() + " Error:" + super.get_train().getError()+ ", Species:" + _pop.getSpecies().size());
		} while(super.get_train().getError() > 0.04);
      
      	NEATNetwork best_network = (NEATNetwork)super.get_train().getCODEC().decode(super.get_train().getBestGenome());
     
      	return best_network;
	}

}
