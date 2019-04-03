package neat;

import java.io.File;

import org.encog.ConsoleStatusReportable;
import org.encog.Encog;
import org.encog.ml.MLRegression;
import org.encog.ml.data.versatile.VersatileMLDataSet;
import org.encog.ml.data.versatile.columns.ColumnDefinition;
import org.encog.ml.data.versatile.columns.ColumnType;
import org.encog.ml.data.versatile.sources.CSVDataSource;
import org.encog.ml.data.versatile.sources.VersatileDataSource;
import org.encog.ml.factory.MLMethodFactory;
import org.encog.ml.model.EncogModel;
import org.encog.util.csv.CSVFormat;
import org.encog.util.simple.EncogUtility;

/**
 * XOR: This example is essentially the "Hello World" of neural network
 * programming.  This example shows how to construct an Encog neural
 * network to predict the output from the XOR operator.  This example
 * uses backpropagation to train the neural network.
 *
 * This example attempts to use a minimum of Encog features to create and
 * train the neural network.  This allows you to see exactly what is going
 * on.  For a more advanced example, that uses Encog factories, refer to
 * the XORFactory example.
 *
 */
public class Test {

	/**
    public static double XOR_INPUT[][] = { { 0.0, 0.0 }, { 1.0, 0.0 },
            { 0.0, 1.0 }, { 1.0, 1.0 } };
     * The ideal data necessary for XOR.
    public static double XOR_IDEAL[][] = { { 0.0 }, { 1.0 }, { 1.0 }, { 0.0 } };    
     * The main method.
     * @param args No arguments are used.
     */
    public static void main(final String args[]) {

    File filename = new File("solar.txt");
   
    	CSVFormat format = new CSVFormat ( '.' ,' ') ; 
    	VersatileDataSource source = new CSVDataSource(filename , true ,format) ;
    	VersatileMLDataSet data = new VersatileMLDataSet(source) ;
    	data.getNormHelper().setFormat(format) ;
    	ColumnDefinition columnSSN = data.defineSourceColumn("SSN", ColumnType.continuous) ;
    	ColumnDefinition columnDEV = data.defineSourceColumn( "DEV" , ColumnType.continuous) ;
    	data.defineSourceColumn("MON",ColumnType.continuous);
    	data.defineSingleOutputOthersInput(columnSSN);
    	
    	data.analyze();
   
    	
      
        EncogModel model = new EncogModel(data);
		model.selectMethod(data, MLMethodFactory.TYPE_NEAT);
       
		
		model.setReport(new ConsoleStatusReportable());
        data.normalize();
     	data.setLagWindowSize(90);
     	data.setLeadWindowSize(1);
     	
     	
     	model.holdBackValidation(0.3, false, 1001);
     	model.selectTrainingType(data);
     	//model.train(true);
     	
     	
     	MLRegression best_method = (MLRegression)model.train(60, false);
     	EncogUtility.evaluate(best_method, model.getValidationDataset());
     	

        Encog.getInstance().shutdown();
    }
}
