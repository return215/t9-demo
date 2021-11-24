package predictive.dictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DictionaryList implements DictionaryBase {
	
	private ArrayList<WordSig> list;
	
	/**
	 * Create dictionary with dictionary file from path.
	 * 
	 * @param wordsPath Path to words dictionary file
	 * @throws IOException if file not found in the working directory
	 */
	public DictionaryList(String wordsPath) throws IOException {
		list = new ArrayList<>();
		ArrayList<String> words = DUtil.readDictionaryFile(wordsPath);
		
		for (String w: words) {
			list.add(new WordSig(w));
		}
		
		java.util.Collections.sort(list);
	}
	
	public Set<String> signatureToWords(String sig) {
		Set<String> words = new HashSet<>();
		
		// binarySearch can only compare WordSig to WordSig.
		// It cannot find WordSig from just a String because
		// WordSig is not derived from String.
		// The "hack" is to wrap the target signature into a WordSig with
		// an empty word. WordSig comparator has been designed to sort
		// by signature first, then the word.
		// By using an empty word, it is guaranteed that it will hit the first
		// signature of the sequence.
		int pos = java.util.Collections.binarySearch(list, new WordSig("", sig));
		
		// Because the placeholder WordSig does not exist in the list,
		// the position falls into the negative range. The position is defined as
		// pos = (-(insertion_point) - 1)
		// The insertion point is where the WordSig element would be
		// if it was an insertion operation instead.
		int ipoint = - pos - 1;
		
		// if found
		if (ipoint > -1 && ipoint < list.size()) {
			WordSig ws = list.get(ipoint);
			while (ws.getSig().equals(sig)) {
				words.add(ws.getWord());
				ipoint++;
				ws = list.get(ipoint);
			}
		}
		
		return words;
	}
}
