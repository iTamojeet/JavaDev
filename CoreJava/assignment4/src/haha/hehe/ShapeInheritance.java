package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// Class to create circle and rectangle objects then find their respective areas by calling overridden method
public class ShapeInheritance {
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		Rectangle rectangle = new Rectangle(5, 6);

		System.out.println("Area of Circle: " + circle.area());
		System.out.println("Area of Rectangle: " + rectangle.area());
	}
}
