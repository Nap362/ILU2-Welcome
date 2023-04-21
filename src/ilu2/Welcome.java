package ilu2;

public class Welcome {
	public static String welcome(String input) {
		StringBuilder output = new StringBuilder();
		output.append("Hello, ");
		if (input==null || input.trim()=="") {
			output.append("my friend");
		}
		else {
			char[] inputChar = input.toCharArray();
			inputChar[0]=Character.toUpperCase(inputChar[0]);
			output.append(new String(inputChar));
		}
		return output.toString();
	}
}
