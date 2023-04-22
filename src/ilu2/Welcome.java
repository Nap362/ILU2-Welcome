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

	/* write occurences if more than one */
	private static String timesToString(int number) {
		if (number > 1) {
			return " (x" + number + ")";
		}
		return "";
	}

	/* count occureneces for each names */
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

	/*
	 * return first index of the name to find (never -1 because name always present
	 * at least 1 time)
	 */
	private static int getIndexFirst(String[] names, String toFind) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].strip().equals(toFind)) {
				return i;
			}
		}
		return -1;
	}

	/* make output if input of welcome not null */
	private static String fusionUpperAndLower(StringBuilder lowerOutput, StringBuilder upperOutput) {
		StringBuilder output = new StringBuilder();
		if (!lowerOutput.isEmpty()) {
			output.append(addHello(lowerOutput));
			if (!upperOutput.isEmpty()) {
				output.append(". AND ");
			}
		}
		if (!upperOutput.isEmpty()) {
			output.append(addHello(upperOutput).toUpperCase() + " !");
		}
		return output.toString();
	}

	/* add hello to list of names by considering presence of yoda */
	private static String addHello(StringBuilder names) {
		StringBuilder output = new StringBuilder();
		if (names.indexOf("Yoda") != -1 || names.indexOf("YODA") != -1) {
			output.append(deleteLastComma(names).replace(0, 2, "") + ", Hello");
		} else {
			output.append("Hello" + deleteLastComma(names));
		}
		return output.toString();
	}

	private static StringBuilder deleteLastComma(StringBuilder list) {
		int last = list.lastIndexOf(",");
		int first = list.indexOf(",");
		/*
		 * no occurence of "," -> last=first= -1 / 1 occurence of "," -> last=first only
		 * 1 name
		 */
		if (last != first) {
			list.replace(last, last + 1, " and");
		}
		return list;
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
