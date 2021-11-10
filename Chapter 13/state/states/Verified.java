package edu.bpb.oops.pattern.ch13.state.states;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import edu.bpb.oops.pattern.ch13.state.BoardingPassKiosk;
import edu.bpb.oops.pattern.ch13.state.State;

/**
 * After input validation/verification the control is transferred here for further processing. <br>
 * Verified state is where the majority of processing takes place. 
 * 
 * @author Lalit Mehra
 * @since Dec 10, 2019
 *
 */
public class Verified implements State {

	private BoardingPassKiosk kiosk;

	public Verified(BoardingPassKiosk kiosk) {
		this.kiosk = kiosk;
	}

	/**
	 * Generates a random seat matrix 
	 * @return seat matrix of size 10 cross 5
	 */
	private boolean[][] fetchSeatMatrix() {
		/* assuming a default seat matrix with 10 rows and 5 columns */
		boolean[][] seatMatrix = new boolean[10][5];

		/* fill seat matrix with random values */
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 5; col++) {
				seatMatrix[row][col] = ThreadLocalRandom.current().nextBoolean();
			}
		}

		return seatMatrix;
	}

	/**
	 * Assist with cosmetic beautification 
	 */
	private void printHorizontalBorder() {
		IntStream.rangeClosed(1, 11).forEach((x) -> System.out.print("-"));
		System.out.println();
	}

	/**
	 * Displays the seat matrix to the user
	 */
	private void displaySeatMatrix() {
		boolean seatMatrix[][] = fetchSeatMatrix();
		for (int row = 0; row < 10; row++) {
			printHorizontalBorder();
			for (int col = 0; col < 5; col++) {
				boolean x = seatMatrix[row][col];
				System.out.printf("|%s", !x ? "x" : " ");
			}
			System.out.println("|");
		}
		printHorizontalBorder();
	}

	/**
	 * Assists with seat selection  
	 */
	@Override
	public void pickSeats(Scanner scanner) {

		System.out.println("\n Seat Matrix ");
		displaySeatMatrix();

		System.out.print("Enter Seat: ");
		String seat = scanner.next();
		kiosk.setSeat(seat);

		kiosk.setState(kiosk.getReview());

	}

}
