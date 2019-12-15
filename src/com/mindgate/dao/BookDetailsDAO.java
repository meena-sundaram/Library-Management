package com.mindgate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindgate.pojo.BookDetails;

public class BookDetailsDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;
	private int count;
	private String url = "jdbc:mysql://localhost:3306/library_management";
	private String user = "root";
	private String password = "";
	private List<BookDetails> bookList = new ArrayList<BookDetails>();

	public boolean addNewBook(BookDetails bookDetails) {
		sql = "insert into book_details values(?,?,?)";
		try {
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bookDetails.getBookId());
			preparedStatement.setString(2, bookDetails.getTitle());
			preparedStatement.setString(3, bookDetails.getAuthor());
			count = preparedStatement.executeUpdate();
			connection.close();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean updateBook(int bookId, String title) {
		sql = "update book_details set title=? where bookid=?";
		try {
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title);
			preparedStatement.setInt(2, bookId);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean deleteBook(int bookId) {
		sql = "delete from book_details where bookid=?";
		try {
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bookId);
			count = preparedStatement.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<BookDetails> displayBook() {
		sql = "select * from book_details";
		try {
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BookDetails bookDetails = new BookDetails();
				bookDetails.setBookId(resultSet.getInt("bookId"));
				bookDetails.setTitle(resultSet.getString("title"));
				bookDetails.setAuthor(resultSet.getString("author"));
				bookList.add(bookDetails);
			}
			return bookList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
