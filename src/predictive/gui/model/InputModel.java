package predictive.gui.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Optional;
import java.util.Set;

import predictive.PredictivePrototype;
import predictive.dictionary.DictionaryBase;
import predictive.dictionary.DictionaryList;

@SuppressWarnings("deprecation")
public class InputModel extends Observable {

	DictionaryBase dict;
	ArrayList<InputWord> inputs;
	
	public InputModel(DictionaryBase dict) {
		// TODO Auto-generated constructor stub
		this.dict = dict;
		this.inputs = new ArrayList<>();
		// add first input
		inputs.add(new InputWord(dict));
	}
	
	public void nextWord() {
		inputs.add(new InputWord(dict));
		update();
	}
	
	public void prevWord() {
		// ensure only one word remain
		if (inputs.size() > 1)
			inputs.remove(inputs.size() - 1);
		update();
	}
	
	private InputWord getCurrentInput() {
		return inputs.get(inputs.size() - 1);
	}
	
	public String getCurrentWord() {
		return getCurrentInput().getWord();
	}
	
	public void cycleCurrentWord() {
		getCurrentInput().nextWord();

		update();
	}

	public void cycleCurrentWordBack() {
		getCurrentInput().prevWord();
		update();
	}
	
	public void addOneChar(char c) {
		getCurrentInput().addOneChar(c);
		update();
	}
	
	public void removeOneChar() {
		InputWord i = getCurrentInput();
		
		if (i.isEmpty())
			prevWord();
		else
			i.removeOneChar();
		
		update();
	}
	
	private void update() {
		// Functional programming style
		String doc = inputs.stream()
				.map((InputWord i) -> i.getWord())
				.reduce((String a, String b) -> a + " " + b)
				.orElse("");
		// mark object as changed, otherwise
		// no update will happen
		setChanged();
		notifyObservers(doc);
	}
	
	class InputWord {
		DictionaryBase dict;
		ArrayList<String> words;
		/** Mutable internal string */
		StringBuilder sig_b;
		int words_cursor;
		
		static final String UNKNOWN = "?";
		
		public InputWord(DictionaryBase dict) {
			// TODO Auto-generated constructor stub
			this.words = new ArrayList<>();
			this.dict = dict;
			this.sig_b = new StringBuilder();
		}
		
		public boolean isEmpty() {
			return length() == 0;
		}
		
		public int length() {
			return this.sig_b.length();
		}
		
		public boolean hasWord() {
			return !this.words.isEmpty();
		}
		
		public String getWord() {
			if (!hasWord()) {
				// Only works on Java 11+
				// return UNKNOWN.repeat(length());
				return String.join("", Collections.nCopies(length(), UNKNOWN));
			}
			else
				return words.get(this.words_cursor);
		}
		
		public String nextWord() {
			if (hasWord()) {
				
				words_cursor++;
			
				// If out of bounds, roll around.
				if (words_cursor >= words.size())
					words_cursor %= words.size();
			}
			
			return getWord();
		}
		
		public String prevWord() {
			if (hasWord()) {
				words_cursor--;

				// If out of bounds, roll around.
				if (words_cursor < 0) {
					words_cursor %= words.size();
					words_cursor += words.size();
				}
			}
			
			return getWord();
		}
		
		private void updateWords() {
			Set<String> words = dict.signatureToWords(sig_b.toString());
			this.words.clear();
			this.words.addAll(words);
			this.words_cursor = 0;
		}

		public void addOneChar(char sig_c) {
			sig_b.append(sig_c);
			updateWords();
		}
		
		public void removeOneChar() {
			if (!isEmpty()) {
				sig_b.deleteCharAt(length() - 1);
				updateWords();
			}
		}
	}

}
