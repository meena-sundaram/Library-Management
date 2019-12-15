package com.mindgate.main;

import java.util.Scanner;

public class LibraryMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		String next;
		do {
			System.out.println("---------------Libraray Management--------------\n");
			System.out.println("1. Book Panel 2. Issue Panel 3. Exit");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				BookMain bookMain = new BookMain();
				bookMain.bookMainMethod();
				break;
			case 2:
				IssueMain issueMain = new IssueMain();
				issueMain.issueMainMethod();
				break;
			default:
				System.out.println("Enter the valid input");
				break;
			}
			System.out.println("_______________________________________________________ ");
			System.out.println("Do you want to continue? yes/no");
			next = scanner.next();
		} while (next.equalsIgnoreCase("yes"));
		scanner.close();
	}
}
