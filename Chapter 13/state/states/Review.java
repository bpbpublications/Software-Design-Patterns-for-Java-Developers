package edu.bpb.oops.pattern.ch13.state.states;

import java.util.Scanner;

import edu.bpb.oops.pattern.ch13.state.BoardingPassKiosk;
import edu.bpb.oops.pattern.ch13.state.State;

/**
 * Review state acts as a milestone before the final state 
 * 
 * @author Lalit Mehra
 * @since Dec 10, 2019
 *
 */
public class Review implements State {

	private String CONFIRM_INPUT = "x";
	private BoardingPassKiosk kiosk;

	public Review(BoardingPassKiosk kiosk) {
		this.kiosk = kiosk;
	}

	/**
	 * Displays the user all the inputs provided in the previous states and asks for confirmation
	 */
	@Override
	public void reviewSelection(Scanner scanner) {

		System.out.println(" -- Review Your Selection -- ");
		System.out.printf(" Airline: %s\n", kiosk.getAirline());
		System.out.printf(" PNR: %s\n", kiosk.getPnr());
		System.out.printf(" Seat: %s\n", kiosk.getSeat());

		System.out.printf(" Press 'x' to Confirm: ");
		String input = scanner.next();

		if (CONFIRM_INPUT.equals(input)) {
			kiosk.setState(kiosk.getConfirm());
		} else {
			kiosk.setState(kiosk.getAvailable());
		}

	}

}
