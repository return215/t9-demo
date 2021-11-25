package predictive.gui.util;

import javax.swing.text.html.*;

public class HTMLString {
	public static String create(String text) {
		return "<html>" + text + "</html>";
	}
	
	public static String createMultiline(String[] text) {
		if (text.length == 0)
			return create("");
		String temp = text[0];
		for (int i = 1; i < text.length; ++i) {
			temp += "<br>" + text[i];
		}
		return create(temp);
	}
	
	public static String createKeypadFormat(String label) {
		return createKeypadFormat(label, "");
	}
	
	public static String createKeypadFormat(String label, String sublabel) {
		String[] temp = {
			"<center>" + label + "",
			"",
			sublabel + "</center>"
		};
		
		return createMultiline(temp);
	}
}
