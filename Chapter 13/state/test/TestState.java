package edu.bpb.oops.pattern.ch13.state.test;

import java.util.Scanner;

import edu.bpb.oops.pattern.ch13.state.BoardingPassKiosk;

/**
 * Functional Test to verify the success use case assuming all extenal inputs
 * are fed correctly
 * 
 * @author Lalit Mehra
 * @since Dec 10, 2019
 *
 */
public class TestState {

	public static void main(String[] args) {

		BoardingPassKiosk kiosk = new BoardingPassKiosk();

		try (Scanner scanner = new Scanner(System.in)) {

			kiosk.selectAirline(scanner);

			kiosk.inputPNR(scanner);

			kiosk.pickSeats(scanner);

			kiosk.reviewSelection(scanner);

			kiosk.printBoardingPass();

		}

	}

}
