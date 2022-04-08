package com.LockedMe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lockers {

	static List<String> directory = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		directory.add("z.txt");
		directory.add("b.txt");
		directory.add("a.txt");
		userInput();
	}

	private static void userInput() {
		System.out.print(
				"Application Name: LockedMe.com\t\t\tDevelopers Details: Parikshith Acharya\n\t\t\t\t\t\t\t\t    TEKsystems Global Services\r");
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		while (true) {
			int input = 0;
			System.out.println(
					"1.Display files in the directory\n2.Display different operations on file\n3.Close the apllication\n");
			System.out.println("Please Enter your option..");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.print(">");
			try {

				input = scanner.nextInt();
			} catch (InputMismatchException e) {

			}

			switch (input) {
			case 1:

				Display();
				break;
			case 2:
				userInput2();
				break;
			case 3:
				System.out.println("Applicaton Closed...");
				System.exit(0);
			default:
				System.out.println("Wrong option...Please try again\n");
				break;
			}

		}
	}

	private static void userInput2() {
		while (true) {
			int fileInput = 0;
			System.out.println("1.Add a file\n2.Delete a file\n3.Search a file\n4.Main menu");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.print(">");

			try {
				fileInput = scanner.nextInt();
			} catch (InputMismatchException e) {

			}

			switch (fileInput) {
			case 1:
				System.out.println("Enter the file to be added...");
				String fileAdd = ExtractFilename(scanner.next());
				add(fileAdd);
				break;
			case 2:
				System.out.println("Enter the file to be deleted...");
				String fileDelete = ExtractFilename(scanner.next());
				delete(fileDelete);
				break;
			case 3:
				System.out.println("Enter the file to be searched...");
				String filesearch = ExtractFilename(scanner.next());
				search(filesearch);
				break;
			case 4:
				System.out.println("Going to main menu...\n");
				userInput();
				break;
			default:
				System.out.println("Wrong option...Please try again\n");
				break;
			}
		}
	}

	private static String ExtractFilename(String next) {
		String st = null;
		if (Pattern.matches("([a-zA-Z]:)?([a-zA-Z0-9_.-]+)?((\\\\[a-zA-Z0-9_.-]+)+)?\\\\?", next)) {
			st = next.substring(next.lastIndexOf('\\') + 1);
		}
		return st;
	}

	private static void search(String fileserach) {
		if (directory.contains(fileserach))
			System.out.println("Here is your File: " + fileserach + "\n");
		else
			System.out.println("Cannot find your file in the root directory...\n");
	}

	private static void delete(String fileDelete) {
		if (directory.contains(fileDelete)) {
			directory.remove(fileDelete);
			System.out.println("File Removed Successfully from the root drectory!!\n");
		} else
			System.out.println("File Not Found(FNF)\n");

	}

	private static void add(String fileAdd) {
		if (directory.contains(fileAdd)) {
			System.out.println("File with this name is already Present...\n");
		} else {

			directory.add(fileAdd);
			System.out.println("File Added Successfully to the root directory!!\n");
		}

	}

	private static void Display() {
		Collections.sort(directory);
		if (directory.isEmpty())
			System.out.println("Directory is Empty!!...No files To display!!\n");
		else
			System.out.println(directory + "\n");
	}

}
