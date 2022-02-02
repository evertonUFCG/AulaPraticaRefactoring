package edu.psoft.refactorings;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
	private String name;
	private ArrayList<Rental> rentals = new ArrayList<Rental>();

	public Customer (String name){
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	public String getName (){
		return name;
	}

	public String statement() {
		Iterator<Rental> rentalsIterator = rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentalsIterator.hasNext()) {
			Rental each = (Rental) rentalsIterator.next();

			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+ "\t" +
					String.valueOf(each.getCharge()) + "\n";

		}
		//add footer lines
		result +=  "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentPoints()) +
				" frequent renter points";
		return result;
	}

	int getFrequentRenterPoints(Rental each){
		if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
				each.getDaysRented() > 1) return 2;
		return 1;
	}
	
	double getTotalCharge(){
		double result = 0;
		Iterator<Rental> rentalsIterator = rentals.iterator();
		while (rentalsIterator.hasNext()) {
			Rental each = (Rental) rentalsIterator.next();

			result += each.getCharge();

		}
		return result;
	}
	
	int getTotalFrequentPoints() {
		Iterator<Rental> rentalsIterator = rentals.iterator();
		int result = 0;
		while (rentalsIterator.hasNext()) {
			Rental each = (Rental) rentalsIterator.next();

			result+= getFrequentRenterPoints(each);
		}
		return result;
	}

}