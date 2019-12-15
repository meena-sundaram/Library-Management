package com.mindgate.pojo;

public class BookDetails {
private int bookId;
private String title;
private String author;
public BookDetails() {
	// TODO Auto-generated constructor stub
}
public BookDetails(int bookId, String title, String author) {
	this.bookId = bookId;
	this.title = title;
	this.author = author;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
@Override
public String toString() {
	return "BookDetails [bookId=" + bookId + ", title=" + title + ", author=" + author + "]";
}

}
