package invaders;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Parser {
	
	public static char[][] readInput(String source) throws Exception {
		if(source == null || source.isEmpty())
			return null;
		
		String path = Commons.INPUT_BASE_PATH + source;
	
		return getFromPath(path);
	}
	
	public static List<char[][]> readInvaders() throws Exception {
		File folder = new File(Commons.INVADERS_BASE_PATH);
	
		List<char[][]> invaders = new ArrayList<>();
		for(File file : folder.listFiles()) {
			try {
			char[][] invader = getFromPath(file.getPath());
			
			if(invader != null)
				invaders.add(invader);
			}catch(Exception e) {
				throw new Exception("Problem getting invaders patterns");
			}
		}
		
		return invaders;
	}
	
	private static char[][] getFromPath(String path) throws Exception{
		try {
			List<char[]> input = new ArrayList<>();
			Stream<String> stream = Files.lines(Paths.get(path),Charset.defaultCharset());
			stream.forEach(a -> input.add(a.toCharArray()));
            
			stream.close();
			
			if(input.isEmpty())
				return null;
			 
			char[][] result = new char[input.size()][input.get(0).length];
			return input.toArray(result);
		}catch (Exception e) {
			throw new Exception("The input could not be processed");
		}
	}

}
