package ml_models;

import org.encog.ml.data.versatile.VersatileMLDataSet;
import org.encog.ml.ea.train.EvolutionaryAlgorithm;
import org.encog.ml.factory.MLMethodFactory;
import org.encog.ml.model.EncogModel;
import org.encog.neural.neat.NEATNetwork;

public abstract class ML_Model<E> {
	
	public VersatileMLDataSet get_data() {
		return _data;
	}

	public void set_data(VersatileMLDataSet _data) {
		this._data = _data;
	}

	public EncogModel get_model() {
		return _model;
	}

	public void set_model(EncogModel _model) {
		this._model = _model;
	}

	public EvolutionaryAlgorithm get_train() {
		return _train;
	}

	public void set_train(EvolutionaryAlgorithm _train) {
		this._train = _train;
	}

	private VersatileMLDataSet _data;
	private EncogModel _model;
	private  EvolutionaryAlgorithm _train;
	
	protected String setType(String type) { 
		_model.selectMethod(_data, type); //TODO: data still null here too.
		return type;
	}
	public abstract E Train();
	

}
