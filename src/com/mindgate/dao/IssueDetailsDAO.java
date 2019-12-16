package com.mindgate.dao;

import com.mindgate.pojo.IssueDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IssueDetailsDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;
	private int count;
	private String url = "jdbc:mysql://localhost:3306/library_management";
	private String user = "root";
	private String password = "";
	private List<IssueDetails> issueList = new ArrayList<IssueDetails>();

	public boolean issueBook(int bookId) {
		// sql = "insert into issue_details values(?,?,now(),now()+interval 8
		// day, 'issued')";
		sql = "insert into issue_details(bookid,issuedate, returndate, status) values(?,now(),now()+interval 8 day, 'issued')";
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

	public boolean bookReturn(int issuedId) {
		sql = "update issue_details set status='returned', returndate=now() where issueid=?";
		try {
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, issuedId);
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
		sql = "delete from issue_details where bookid=?";
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

	public List<IssueDetails> displayBook() {
		sql = "select * from issue_details";
		try {
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				IssueDetails issueDetails = new IssueDetails();
				issueDetails.setIssueId(resultSet.getInt("issueId"));
				issueDetails.setBookId(resultSet.getInt("bookId"));
				issueDetails.setIssueDate(resultSet.getDate("issueDate"));
				issueDetails.setReturnDate(resultSet.getDate("returnDate"));
				issueDetails.setStatus(resultSet.getString("status"));
				// System.out.println(issueList);
				issueList.add(issueDetails);
			}
			return issueList;
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
