package predictive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Sigs2WordsProto {

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
			for (String s: l) {
				Set<String> words = PredictivePrototype.signatureToWords(s);
				System.out.println(s + " => " + words.toString());
			}
		}
	}

}
