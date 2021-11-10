package edu.bpb.oops.pattern.ch13.state.states;

import java.util.Scanner;
import java.util.regex.Pattern;

import edu.bpb.oops.pattern.ch13.state.BoardingPassKiosk;
import edu.bpb.oops.pattern.ch13.state.State;

/**
 * Once the process is triggered the control is transferred here to take initial input from the user. <br>
 * For {@link BoardingPassKiosk} the initial input is flight PNR   
 * 
 * @author Lalit Mehra
 * @since Dec 10, 2019
 *
 */
public class Waiting implements State {

	private BoardingPassKiosk kiosk;

	public Waiting(BoardingPassKiosk kiosk) {
		this.kiosk = kiosk;
	}

	private static boolean validate(String pnr) {
		/* validation criteria: alphanumeric with length 6 */
		return Pattern.matches("[a-zA-Z0-9]{6}", pnr);
	}

	@Override
	public void inputPNR(Scanner scanner) {

		System.out.printf("Airline: %s | Enter PNR: ", kiosk.getAirlines().get(kiosk.getAirline()));
		String pnr = scanner.nextLine();

		kiosk.setPnr(pnr);

		/* validate PNR */
		if (validate(pnr)) {
			System.out.println(" -- PNR Verified -- ");
			/* transfer the control to verified state */
			kiosk.setState(kiosk.getVerified());
		} else {
			System.out.println(" -- PNR Invalid -- ");
			/* transfer the control to initial state to restart the process */
			kiosk.setState(kiosk.getAvailable());
		}

	}

}
