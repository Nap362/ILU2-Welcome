package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder output = new StringBuilder("Hello");
		if (isNullOrEmpty(input)) {
			output.append(", my friend");
		} else {
			String[] names = input.split(",");
			StringBuilder upperOutput = new StringBuilder();
			StringBuilder lowerOutput = new StringBuilder();
			for (String name : names) {
				if (isUpperCase(name)) {
					upperOutput.append(", " + name);
				} else {
					lowerOutput.append(", " + firstLettertoUpperCase(name));
				}
			}
			if (lowerOutput.isEmpty()) {
				output.replace(0, 5, "HELLO");
				output.append(upperOutput + " !");
			} else {
				output.append(lowerOutput);
				if (!upperOutput.isEmpty()) {
					output.append(". AND HELLO" + upperOutput + " !");
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
