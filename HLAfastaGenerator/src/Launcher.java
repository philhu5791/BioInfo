import java.io.File;
import org.apache.commons.io.FilenameUtils;

public class Launcher {
	private static FastaGenerator generetor;

	public static void main(String[] args) {
	
		generetor = new FastaGenerator();
		File folder = new File("/Users/wwang/Documents/workspace/BioInfo/HLAfastaGenerator/input");
		File[] inputList = folder.listFiles();
		for(int i = 0 ; i < inputList.length; i++){
			if(inputList[i].getName().contains("xml")){
				String fileName = FilenameUtils.removeExtension(inputList[i].getName());
				process(inputList[i], fileName);
			}
			
		}
		
		

	}
	
	private static void process(File input, String outputName){
		File output = new File("./output/" + outputName +".fasta");
		try{
			generetor.run(input,output);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
