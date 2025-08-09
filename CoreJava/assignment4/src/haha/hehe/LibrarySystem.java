package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// library system that creates books for both fiction and non-fiction classes
public class LibrarySystem {
	public static void main(String[] args) {
		FictionBook fiction = new FictionBook("The Hobbit", "J.R.R. Tolkien", "123456789", "Fantasy");
		NonFictionBook nonFiction = new NonFictionBook("Sapiens", "Yuval Noah Harari", "987654321", "History");

		fiction.displayBookInfo();
		nonFiction.displayBookInfo();
	}
}
