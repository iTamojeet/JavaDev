package haha.hehe;

/**
 * Author: Tamojeet
 * 
 * Created: 14.02.2025
 * 
 * (c) Copyright by Myself.
 **/

// this class cretaes all objects or animals and calls their makeSounds
class AnimalSoundSystem {
	public static void main(String[] args) {
		Animal doggy = new Dog();
		Animal pussy = new Cat();
		Animal dino = new Dinosaur();

		// call all the makeSound methods
		doggy.makeSound();
		pussy.makeSound();
		dino.makeSound();
	}
}