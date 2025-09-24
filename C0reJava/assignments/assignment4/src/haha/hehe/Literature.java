package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// this class contains the overridden equals() method
class Literature {
	private String title;
	private String author;
	private double price;

	public Literature(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Literature literature = (Literature) obj;
		return Double.compare(literature.price, price) == 0 && title.equals(literature.title)
				&& author.equals(literature.author);
	}
}
