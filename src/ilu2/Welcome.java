package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder output = new StringBuilder("Hello");
		if (isNullOrEmpty(input)) {
			output.append(", my friend");
		} else {
			if (isUpperCase(input)) {
				output.replace(0, 5, "HELLO");
				output.append(", " + input.toUpperCase() + " !");
			} else {
				String[] names = input.split(",");
				for (String name : names) {
					output.append(", " + firstLettertoUpperCase(name));
				}
			}
		}
		return output.toString();
	}

	private static String firstLettertoUpperCase(String input) {
		char[] inputChar = input.toCharArray();
		inputChar[0] = Character.toUpperCase(inputChar[0]);
		return new String(inputChar);

	}

	private static boolean isNullOrEmpty(String input) {
		return input == null || input.trim().equals("");
	}

	private static boolean isUpperCase(String input) {
		return input.equals(input.toUpperCase());
	}
}
