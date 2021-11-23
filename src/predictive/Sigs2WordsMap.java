package predictive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import predictive.dictionary.DictionaryMap;

public class Sigs2WordsMap {

	public static void main(String[] args) {
		ArrayList<String> l;
		// Check if empty
		if (args.length == 0) {
			l = new ArrayList<>();
			// read from stdin
			Scanner in = new Scanner(System.in);
			while (in.hasNext()) {
				l.add(in.next());
			}
			in.close();
		} else {
			l = new ArrayList<>(Arrays.asList(args));
		}
		
		// only process if not empty
		// It can still be empty from empty stdin
		if (l.size() != 0) {
			try {
				DictionaryMap dict = new DictionaryMap("words");
				for (String s: l) {
					Set<String> words = dict.signatureToWords(s);
					System.out.println(s + " => " + words.toString());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Unable to read dictionary file. Please check if the file exists and can be accessed.");
			}
			
		}
	}

}
