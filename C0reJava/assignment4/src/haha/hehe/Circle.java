package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// Class for circle
class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	double area() {
		return 3.14 * radius * radius;
	}
}