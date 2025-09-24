package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// POJO book class
class Book {
	protected String title;
	protected String author;
	protected String ISBN;

	public Book(String title, String author, String ISBN) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}

	public void displayBookInfo() {
		System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + ISBN);
	}
}