package predictive.dictionary;

import java.util.Set;

/**
 * Base for dictionary classes
 * @author Muhammad Hidayat
 */
public interface DictionaryBase {
	/**
	 * Retrieve words that match the given signature
	 * @param sig The signature
	 * @return A list of words with no duplicates.
	 */
	public Set<String> signatureToWords(String sig);
}
