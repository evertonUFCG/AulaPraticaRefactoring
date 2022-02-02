package edu.psoft.refactorings.tests;

import edu.psoft.refactorings.Customer;
import edu.psoft.refactorings.Movie;
import edu.psoft.refactorings.Rental;

public class Client {

	public static void main(String[] args) {
		Customer customer = new Customer("Everton");
		customer.addRental(new Rental(new Movie("Star Wars", 0), 3));
		customer.addRental(new Rental(new Movie("Frozen", 2), 3));
		customer.addRental(new Rental(new Movie("Matrix Resurrections", 1), 3));
		System.out.println(customer.statement());
		
		System.out.println("-------------------");
		Customer customer2 = new Customer("Jose");
		customer2.addRental(new Rental(new Movie("The Godfather", 0), 3));
		customer2.addRental(new Rental(new Movie("Matrix Resurrections", 1), 3));
		System.out.println(customer2.statement());
		
		System.out.println("-------------------");
		Customer customer3 = new Customer("Maria");
		customer3.addRental(new Rental(new Movie("Moana", 2), 7));
		customer3.addRental(new Rental(new Movie("Frozen", 2), 7));
		customer3.addRental(new Rental(new Movie("The Lion King", 2), 7));
		customer3.addRental(new Rental(new Movie("Aladdin", 2), 7));
		System.out.println(customer3.statement());

	}

}
