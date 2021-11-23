package predictive.dictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import predictive.PredictivePrototype;

public class DictionaryMap {

	private HashMap<String, Set<String> > _map;
	
	public DictionaryMap(String wordsPath) throws IOException {
		ArrayList<String> words = DUtil.readDictionaryFile(wordsPath);
		
		_map = new HashMap<String, Set<String> >();
		
		for (String word : words) {
			String sig = PredictivePrototype.wordToSignature(word);
			_map.putIfAbsent(sig, new HashSet<String>());
			_map.get(sig).add(word);
		}
	}
	
	public Set<String> signatureToWords(String sig) {
		return _map.get(sig);
	}

}
