package ilu2;

public class Welcome {

	public static String welcome(String input) {
		String output = new String();
		if (isNullOrEmpty(input)) {
			output = "Hello, my friend";
		} else {
			String[] names = input.split(",");
			int[] number = getNbrOccurence(names);
			StringBuilder upperOutput = new StringBuilder();
			StringBuilder lowerOutput = new StringBuilder();
			for (int i = 0; i < names.length; i++) {
				if (number[i] != 0) {
					if (isUpperCase(names[i])) {
						upperOutput.append(", " + names[i].strip() + timesToString(number[i]));
					} else {
						lowerOutput.append(", " + firstLettertoUpperCase(names[i].strip()) + timesToString(number[i]));
					}
				}
			}
			output = fusionUpperAndLower(lowerOutput, upperOutput);
		}
		return output;
	}

	private static String timesToString(int number) {
		if (number > 1) {
			return " (x" + number + ")";
		}
		return "";
	}

	private static int[] getNbrOccurence(String[] names) {
		int[] index = new int[names.length];
		for (int i = 0; i < names.length; i++) {
			index[i] = 1;
			int first = getIndexFirst(names, names[i].strip());
			if (first != i) {
				index[first] += 1;
				index[i] = 0;
			}
		}
		return index;
	}

	private static int getIndexFirst(String[] names, String toFind) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].strip().equals(toFind)) {
				return i;
			}
		}
		return -1;
	}

	private static String fusionUpperAndLower(StringBuilder lowerOutput, StringBuilder upperOutput) {
		StringBuilder output = new StringBuilder();
		if (lowerOutput.isEmpty()) {
			output.append("HELLO" + deleteLastComma(upperOutput).toUpperCase() + " !");
		} else {
			output.append("Hello" + deleteLastComma(lowerOutput));
			if (!upperOutput.isEmpty()) {
				output.append(". AND HELLO" + deleteLastComma(upperOutput).toUpperCase() + " !");
			}
		}
		return output.toString();
	}

	private static String deleteLastComma(StringBuilder list) {
		int last = list.lastIndexOf(",");
		int first = list.indexOf(",");
		/*
		 * no occurence of "," -> last=first= -1 / 1 occurence of "," -> last=first only
		 * 1 name
		 */
		if (last != first) {
			list.replace(last, last + 1, " and");
		}
		return list.toString();
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
