package predictive;

import java.util.Set;

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
	
//	public static Set<String> signatureToWords(String signature) {
//		
//	}

}
