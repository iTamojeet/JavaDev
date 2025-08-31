package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// Only non-fiction book class
class NonFictionBook extends Book {
	private String subject;

	public NonFictionBook(String title, String author, String ISBN, String subject) {
		super(title, author, ISBN);
		this.subject = subject;
	}

	public void displayBookInfo() {
		System.out.println("Non-Fiction Book: Title: \"" + title + "\", Author: " + author + ", Subject: " + subject);
	}
}
