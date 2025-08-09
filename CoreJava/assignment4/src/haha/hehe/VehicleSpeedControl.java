package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

public class VehicleSpeedControl {
	public static void main(String[] args) {
		/*
		 * array of Vehicle class that has two objects one of Car and Vehicle classes by
		 * using polymorphism
		 */
		Vehicle[] vehicles = { new Car(), new Bike() };

		// Increase car speed to 50
		vehicles[0].increaseSpeed();
		vehicles[0].increaseSpeed();
		vehicles[0].increaseSpeed();
		vehicles[0].increaseSpeed();
		vehicles[0].increaseSpeed();
		System.out.println("Car speed: " + vehicles[0].speed);

		// Increase bike speed to 15
		vehicles[1].increaseSpeed();
		vehicles[1].increaseSpeed();
		vehicles[1].increaseSpeed();
		System.out.println("Bike speed: " + vehicles[1].speed);
	}
}
