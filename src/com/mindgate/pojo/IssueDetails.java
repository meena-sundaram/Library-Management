package com.mindgate.pojo;

import java.sql.Date;

public class IssueDetails {
	private int issueId;
	private int bookId;
	private Date issueDate;
	private Date returnDate;
	private String status;

	public IssueDetails() {
	}

	public IssueDetails(int issueId, int bookId, Date issueDate, Date returnDate, String status) {
		this.issueId = issueId;
		this.bookId = bookId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.status = status;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getIssueDate() {
		return returnDate;
	} 
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	/*public java.sql.Date getIssueDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}*/
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "IssueDetails [issueId=" + issueId + ", bookId=" + bookId + ", issueDate=" + issueDate + ", returnDate="
				+ returnDate + ", status=" + status + "]";
	}

}
