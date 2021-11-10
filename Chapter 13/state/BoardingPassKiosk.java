package edu.bpb.oops.pattern.ch13.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.bpb.oops.pattern.ch13.state.states.Available;
import edu.bpb.oops.pattern.ch13.state.states.Confirm;
import edu.bpb.oops.pattern.ch13.state.states.Review;
import edu.bpb.oops.pattern.ch13.state.states.Verified;
import edu.bpb.oops.pattern.ch13.state.states.Waiting;

/**
 * BoardingPassKiosk is at the center of this small application whose states are
 * being managed via different classes
 * 
 * @author Lalit Mehra
 * @since Dec 10, 2019
 *
 */
public class BoardingPassKiosk implements Stateful {

	/* stores default set of airlines */
	private Map<Integer, String> airlines;

	private State available;
	private State waiting;
	private State verified;
	private State review;
	private State confirm;

	/* refers to current state of the object */
	private State state;

	/* store user inputs */
	private int airline;
	private String pnr;
	private String seat;

	/**
	 * set the default entries to the airlines map
	 */
	private void setAirlines() {
		airlines = new HashMap<>();
		airlines.put(1, "Air India");
		airlines.put(2, "Emirates");
		airlines.put(3, "Singapore Airlines");
		airlines.put(4, "Lufthansa");
		airlines.put(5, "Air Canada");
	}

	/* instantiate the entity */
	public BoardingPassKiosk() {

		setAirlines();

		this.available = new Available(this);
		this.waiting = new Waiting(this);
		this.verified = new Verified(this);
		this.review = new Review(this);
		this.confirm = new Confirm(this);

		this.state = available;

		this.airline = 0;
	}

	/* getters */
	public Map<Integer, String> getAirlines() {
		return this.airlines;
	}

	public State getAvailable() {
		return available;
	}

	public State getWaiting() {
		return waiting;
	}

	public State getVerified() {
		return verified;
	}

	public State getReview() {
		return review;
	}

	public State getConfirm() {
		return confirm;
	}

	public int getAirline() {
		return airline;
	}

	public String getPnr() {
		return pnr;
	}

	public String getSeat() {
		return seat;
	}
	
	public String getAirlineName() {
		return airlines.get(airline);
	}

	/* setters */
	public void setAirline(int airline) {
		this.airline = airline;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public void setState(State state) {
		this.state = state;
	}

	/*
	 * Different behaviours of the BoardingPassKiosk which are managed by different
	 * states
	 */
	public void selectAirline(Scanner scanner) {
		this.state.selectAirline(scanner);
	}

	public void inputPNR(Scanner scanner) {
		this.state.inputPNR(scanner);
	}

	public void pickSeats(Scanner scanner) {
		this.state.pickSeats(scanner);
	}

	public void reviewSelection(Scanner scanner) {
		this.state.reviewSelection(scanner);
	}

	public void printBoardingPass() {
		this.state.printBoardingPass();
	}

}
