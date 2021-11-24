package predictive.dictionary;

public class WordSig implements Comparable<WordSig>{
	private String word;

	private String sig;

	/**
	 * Create a pair of a word and its signature.
	 * @param word
	 * @param sig
	 */
	public WordSig(String word, String sig) {
		this.word = word;
		this.sig = sig;
	}

	/**
	 * Create a pair of a word and its signature (automatically generated).
	 * @param word
	 */
	public WordSig(String word) {
		this(word, predictive.PredictivePrototype.wordToSignature(word));
	}
	
	public String getWord() {
		return word;
	}
	
	public String getSig() {
		return sig;
	}

	/**
	 * Compares two WordSig pair. It compares the signature first.
	 * If it's the same, compare the word. If it's still the same,
	 * both pairs are the same.
	 */
	@Override
	public int compareTo(WordSig other) {
		// Compare sig first, then compare word
		int sigc = sig.compareTo(other.sig);
		return (sigc != 0) ? sigc : word.compareTo(other.word);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return sig + " => " + word;
	}
	
}
