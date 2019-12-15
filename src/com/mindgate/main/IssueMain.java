package com.mindgate.main;

import java.util.List;
import java.util.Scanner;
import com.mindgate.dao.IssueDetailsDAO;
import com.mindgate.pojo.IssueDetails;

public class IssueMain {
	public void issueMainMethod() {
		int bookId, choice, issueId;
		String next;
		Scanner scanner = new Scanner(System.in);
		IssueDetailsDAO issueDetailsDAO = new IssueDetailsDAO();
		do {
			System.out.println("**************Issue Book Panel****************\n");
			System.out.println("1. Issue Book 2. Return Book 3. Display Books 4. Exit");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the IssueId: ");
				issueId = scanner.nextInt();
				System.out.println("Enter the BookId: ");
				bookId = scanner.nextInt();
				if (issueDetailsDAO.issueBook(issueId, bookId))
					System.out.println("Issued Successful..");
				else
					System.out.println("Attempt failed..");
				break;
			case 2:
				System.out.println("Enter the IssueId: ");
				issueId = scanner.nextInt();
				if (issueDetailsDAO.bookReturn(issueId))
					System.out.println("Book Returned Successful..");
				else
					System.out.println("Attempt failed..");
				break;
			case 3:
				List<IssueDetails> tempList = issueDetailsDAO.displayBook();
				for (IssueDetails issueDetails : tempList) {
					System.out.println(issueDetails);
				}
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("invalid choice");
				break;
			}
			System.out.println("Do you want to continue with Issue panel? yes/no");
			next = scanner.next();
		} while (next.equalsIgnoreCase("yes"));
		//scanner.close();
	}

}
