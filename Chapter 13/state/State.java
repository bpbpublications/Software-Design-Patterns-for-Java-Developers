package edu.bpb.oops.pattern.ch13.state;

import java.util.Scanner;

/**
 * Defines a binding contract for implementation(s) of possible states of <br>
 * {@link BoardingPassKiosk} with multiple methods relevant to those states
 * 
 * @author Lalit Mehra
 * @since Dec 10, 2019
 *
 */
public interface State {
	
	/**
	 * Assist in selection of the Airline 
	 * @param scanner 
	 */
	public default void selectAirline(Scanner scanner) {
		System.out.printf("Invalid Operation");
	}
	
	/**
	 * Assist in PNR input
	 * @param scanner
	 */
	public default void inputPNR(Scanner scanner) {
		System.out.printf("Invalid Operation");
	}
	
	/**
	 * Assist in picking seats for the travel
	 * @param scanner
	 */
	public default void pickSeats(Scanner scanner) {
		System.out.printf("Invalid Operation");
	}
	
	/**
	 * Assist in review and confirm the selection
	 * @param scanner
	 */
	public default void reviewSelection(Scanner scanner) {
		System.out.printf("Invalid Operation");
	}
	
	/**
	 * Assist in printing the final result
	 */
	public default void printBoardingPass() {
		System.out.printf("Invalid Operation");
	}
	
}
