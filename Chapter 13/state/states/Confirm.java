package edu.bpb.oops.pattern.ch13.state.states;

import edu.bpb.oops.pattern.ch13.state.BoardingPassKiosk;
import edu.bpb.oops.pattern.ch13.state.State;

/**
 * Final state that assist with result display  
 * 
 * @author Lalit Mehra
 * @since Dec 10, 2019
 *
 */
public class Confirm implements State {

	private BoardingPassKiosk kiosk;

	public Confirm(BoardingPassKiosk kiosk) {
		this.kiosk = kiosk;
	}

	/**
	 * Displays the boarding pass to the user 
	 */
	@Override
	public void printBoardingPass() {
		System.out.println(" Boarding Pass Details ");
		System.out.printf(" Airline: %s\n", kiosk.getAirlineName());
		System.out.printf(" PNR: %s\n", kiosk.getPnr());
		System.out.printf(" Seat: %s\n", kiosk.getSeat());
	}

}
