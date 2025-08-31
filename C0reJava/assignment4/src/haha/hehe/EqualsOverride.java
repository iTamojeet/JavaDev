package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// this class calls the overridden equals() method and checks if two objects are same or not!
class EqualsOverride {
	public static void main(String[] args) {
		Literature book1 = new Literature("Eloquent Javascript", "Marijn Haverbeke", 2000);
		Literature book2 = new Literature("Eloquent Javascript", "Marijn Haverbeke", 2000);

		System.out.println("Book1 and Book2 are equal: " + book1.equals(book2));
	}
}
