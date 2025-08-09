package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// Class for rectangle
class Rectangle extends Shape {
	private double length, width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	double area() {
		return length * width;
	}
}