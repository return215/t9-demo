package predictive.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DUtil {
	public static ArrayList<String> readDictionaryFile(String path) throws IOException {
		Path file = Paths.get(path);
		BufferedReader br = Files.newBufferedReader(file);
		String line = null;
		ArrayList <String> result = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			result.add(line);
		}
		return result;
	}

}
