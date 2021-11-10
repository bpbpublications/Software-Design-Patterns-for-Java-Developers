package edu.bpb.oops.pattern.ch13.state.states;

import java.util.Map;
import java.util.Scanner;

import edu.bpb.oops.pattern.ch13.state.BoardingPassKiosk;
import edu.bpb.oops.pattern.ch13.state.State;

/**
 * Initial state of the {@link BoardingPassKiosk} <br>
 * Control returns to this state after a successful run or if wrong PNR is entered
 * 
 * @author Lalit Mehra
 * @since Dec 10, 2019
 *
 */
public class Available implements State {

	private BoardingPassKiosk kiosk;

	public Available(BoardingPassKiosk kiosk) {
		this.kiosk = kiosk;
	}

	@Override
	public void selectAirline(Scanner scanner) {

		Map<Integer, String> airlines = this.kiosk.getAirlines();

		System.out.println("Select the Airlines");
		airlines.forEach((key, value) -> {
			System.out.printf("%d -> %s\n", key, value);
		});
		System.out.print(": ");

		int airline = scanner.nextInt(); scanner.nextLine();
		kiosk.setAirline(airline);
		kiosk.setState(kiosk.getWaiting());

	}

}
