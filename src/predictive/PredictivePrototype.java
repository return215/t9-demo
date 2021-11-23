package predictive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import predictive.dictionary.DUtil;
import predictive.dictionary.DictionaryMap;

public class PredictivePrototype {

	private static char letterToNumcode(char c) {
		switch (c) {
		case '1':
		case '.':
		case ',':
		case '-':
		case '+':
		case '\'':
		case '"':
		case '/':
		case '\\':
		case '&':
		case '(':
		case ')':
		case '%':
		case '#':
			return '1';
		case '2':
		case 'a':
		case 'b':
		case 'c':
			return '2';
		case '3':
		case 'd':
		case 'e':
		case 'f':
			return '3';
		case '4':
		case 'g':
		case 'h':
		case 'i':
			return '4';
		case '5':
		case 'j':
		case 'k':
		case 'l':
			return '5';
		case '6':
		case 'm':
		case 'n':
		case 'o':
			return '6';
		case '7':
		case 'p':
		case 'q':
		case 'r':
		case 's':
			return '7';
		case '8':
		case 't':
		case 'u':
		case 'v':
			return '8';
		case '9':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			return '9';
		case '0':
			return '0';
		default:
			return ' ';
		}
	}
	
	/** Implementation using StringBuilder */
	public static String wordToSignature(String word) {
		StringBuilder temp = new StringBuilder();
		
		for (char c : word.toLowerCase().toCharArray()) {
			temp.append(letterToNumcode(c));
		}
		
		return temp.toString();
	}
	
	/**
	 * Search words that match the specified signature.
	 * A prototype, brute-force implementation.
	 * @deprecated More efficient implementations are available.
	 * @param signature Signature to check
	 * @return Distinct list of words
	 * @see DictionaryMap
	 */
	public static Set<String> signatureToWords(String signature) {
		HashSet<String> _set = new HashSet<String>();

		try {
			// This is a bottleneck. It will be invoked with every call.
			// If we need to reuse this over and over, it will take
			// too long just to reload the file again.
			// It is best if we only load it once and then read from it.
			ArrayList<String> words = DUtil.readDictionaryFile("words");
			for (String word : words) {
				String sig = PredictivePrototype.wordToSignature(word);
				if (sig.equals(signature)) {
					_set.add(word);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Unable to read dictionary file. Please check if the file exists and can be accessed.");
		}
		
		return _set;
	}

}
