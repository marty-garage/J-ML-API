package neat;
import java.io.File;
import java.net.URL;

import org.encog.Encog;
import org.encog.ml.CalculateScore;
import org.encog.ml.data.versatile.VersatileMLDataSet;
import org.encog.ml.data.versatile.columns.ColumnDefinition;
import org.encog.ml.data.versatile.columns.ColumnType;
import org.encog.ml.data.versatile.sources.CSVDataSource;
import org.encog.ml.data.versatile.sources.VersatileDataSource;
import org.encog.ml.ea.train.EvolutionaryAlgorithm;
import org.encog.ml.factory.MLMethodFactory;
import org.encog.ml.model.EncogModel;
import org.encog.neural.neat.NEATNetwork;
import org.encog.neural.neat.NEATPopulation;
import org.encog.neural.neat.NEATUtil;
import org.encog.neural.networks.training.TrainingSetScore;
import org.encog.util.csv.CSVFormat;
import org.encog.util.simple.EncogUtility;
public class NeaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
	    	
	    	
	    	EncogModel model = new EncogModel(data);
	    	
	    	
	    	
		model.selectMethod(data, MLMethodFactory.TYPE_NEAT);
		
	    	
	    	data.analyze();
	    	 data.normalize();
      	data.setLagWindowSize(90);
      	data.setLeadWindowSize(4);
      	
      	model.holdBackValidation(0.3, false, 1001);
      	
      	NEATPopulation pop = new NEATPopulation(30,4,1000);
      	pop.setInitialConnectionDensity(1.0);// not required, but speeds training
		pop.reset();
		
		
		
		
		
      	//EncogUtility.trainToError(train, error);
		
      	CalculateScore score = new TrainingSetScore(data);
      	
      	//MLMethodGenomeFactory
      	final EvolutionaryAlgorithm train = NEATUtil.constructNEATTrainer(pop, score);
      	do {
			train.iteration();
			System.out.println("Epoch #" + train.getIteration() + " Error:" + train.getError()+ ", Species:" + pop.getSpecies().size());
		} while(train.getError() > 0.04);
      
      	NEATNetwork best_network = (NEATNetwork)train.getCODEC().decode(train.getBestGenome());
     
      	EncogUtility.evaluate(best_network, model.getValidationDataset());
     	

        Encog.getInstance().shutdown();
      	

	}

}
