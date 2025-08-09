package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// Only fiction book class 
class FictionBook extends Book {
	private String genre;

	public FictionBook(String title, String author, String ISBN, String genre) {
		super(title, author, ISBN);
		this.genre = genre;
	}

	public void displayBookInfo() {
		System.out.println("Fiction Book: Title: \"" + title + "\", Author: " + author + ", Genre: " + genre);
	}
}