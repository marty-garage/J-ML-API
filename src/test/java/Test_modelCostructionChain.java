import java.io.File;
import java.net.URL;

import org.encog.ml.data.versatile.VersatileMLDataSet;
import org.encog.ml.data.versatile.columns.ColumnDefinition;
import org.encog.ml.data.versatile.columns.ColumnType;
import org.encog.ml.data.versatile.sources.CSVDataSource;
import org.encog.ml.data.versatile.sources.VersatileDataSource;
import org.encog.util.csv.CSVFormat;


import ml_models.ModelsFactory;
import ml_models.Neat_model;

public class Test_modelCostructionChain<T> {

	public Test_modelCostructionChain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
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
	    	
	    	ModelsFactory<?> factory = new ModelsFactory();
	    	
	    	
	    	
	    	try {
				factory.getModel(Class.forName("ml_models.Neat_model"),data);
			} catch (InstantiationException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// TODO Auto-generated method stub

	}

}
