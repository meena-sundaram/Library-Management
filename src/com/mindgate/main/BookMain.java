package com.mindgate.main;

import java.util.List;
import java.util.Scanner;

import com.mindgate.dao.BookDetailsDAO;
import com.mindgate.pojo.BookDetails;

public class BookMain {
	public void bookMainMethod() {
	//public static void main(String [] args){
		int choice;
		int bookId;
		String title, author, next;
		Scanner scanner = new Scanner(System.in);
		BookDetailsDAO bookDetailsDAO = new BookDetailsDAO();
		do {
			System.out.println("**************Book Main****************");
			System.out.println("1. Add Book 2. Update Book 3. Delete Book 4. Display Books 5. Exit");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the Book Id:");
				bookId = scanner.nextInt();
				System.out.println("Enter the Book Title:");
				title = scanner.next();
				System.out.println("Enter the Book Author:");
				author = scanner.next();
				BookDetails bookDetails = new BookDetails(bookId, title, author);
				if (bookDetailsDAO.addNewBook(bookDetails))
					System.out.println("Added SuccessFul...");
				else
					System.out.println("Attempt failed....");
				break;
			case 2:
				System.out.println("Enter the Book Id:");
				bookId = scanner.nextInt();
				System.out.println("Enter the Book Title:");
				title = scanner.next();
				if (bookDetailsDAO.updateBook(bookId, title))
					System.out.println("Updated SuccessFul...");
				else
					System.out.println("Attempt failed....");
				break;
			case 3:
				System.out.println("Enter the Book Id:");
				bookId = scanner.nextInt();
				if (bookDetailsDAO.deleteBook(bookId))
					System.out.println("Deleted SuccessFul...");
				else
					System.out.println("Attempt failed....");
				break;
			case 4:
				List<BookDetails> tempList=bookDetailsDAO.displayBook();
				for (BookDetails bookDetail : tempList) {
					System.out.println(bookDetail);
				}				
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("invalid choice");
				break;
			}
			System.out.println("Do you want to continue with Book panel? yes/no");
			next = scanner.next();
		} while (next.equalsIgnoreCase("yes"));
		//scanner.close();
	}

}
