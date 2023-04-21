package ilu2;

public class Welcome {
	
	public static String welcome(String input) {
		StringBuilder output = new StringBuilder();
		output.append("Hello, ");
		if (input==null || input.trim().equals("")) {
			output.append("my friend");
		}
		else {
			if (isUpperCase(input)) {
				output.replace(0, 5, "HELLO");
				output.append(input.toUpperCase() + " !");
			}
			else {
				output.append(firstLettertoUpperCase(input));
			}
		}
		return output.toString();
	}
	
	private static String firstLettertoUpperCase(String input) {
		char[] inputChar = input.toCharArray();
		inputChar[0]=Character.toUpperCase(inputChar[0]);
		return new String(inputChar);
		
	}
	
	
	private static boolean isUpperCase(String input) {
		return input.equals(input.toUpperCase());
	}
}
