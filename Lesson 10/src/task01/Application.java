/*
 * Homework, module "Java Core"
 * Lesson 10
 * task01
 */

package task01;

import java.util.Scanner;

/**
 * Application about strings
 * 
 * @author Yura
 * 
 * @version 1.0
 * 
 */

public class Application {

	static void menu() {
		System.out.println("Enter 1 to check if the word you entered is a palindrome");
		System.out.println("Enter 2 to replace all vowels in the entered sentence with a dash");
		System.out.println("Enter 3 to count the number of words in a sentence");
		System.out.println("Enter 4 to find the most used word in a sentence");
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			menu();

			switch (sc.next()) {

			case "1": {
				System.out.println("Enter word");
				sc = new Scanner(System.in);
				String word = sc.next().toUpperCase();

				if (word.length() == 5) {
					if (word.charAt(0) == word.charAt(4) && word.charAt(1) == word.charAt(3)) {
						System.out.println("This word is palindrom");
					} else {
						System.out.println("This word is not palindrom");
					}
				} else {
					try {
						throw new Exception();
					} catch (Exception e) {
						System.err.println("Enter word of 5 letters");
					}
				}
			}
				break;

			case "2": {
				System.out.println("Enter sentence");
				sc = new Scanner(System.in);
				String st = sc.nextLine();
				st = st.replaceAll("[AaEeIiOoUu]", "-");
				System.out.println(st);
			}
				break;

			case "3": {
				System.out.println("Enter sentence");
				sc = new Scanner(System.in);
				String st = sc.nextLine();

				int cnt = 1;
				int ln = st.length();

				for (int i = 0; i < ln; i++) {
					if (st.charAt(i) == ' ') {
						cnt++;
					}
				}
				System.out.println("This sentence has " + cnt + " words.");
			}
				break;

			case "4": {
				System.out.println("Enter sentence");
				sc = new Scanner(System.in);
				String st = sc.nextLine();
				String[] words = st.split("\\s+");

				int finalCount = 0;
				int tempCount = 0;
				String mostlyUsedWord = null;

				for (String word : words) {
					tempCount = 0;
					for (String w : words) {
						if (word.equalsIgnoreCase(w)) {
							tempCount++;
						}
					}
					if (tempCount >= finalCount) {
						finalCount = tempCount;
						mostlyUsedWord = word;
					}
				}
				System.out.println("The most used word in sentence is " + mostlyUsedWord + " , count = " + finalCount);
			}
				break;
			}
		}
	}
}
