package edu.bpb.oops.pattern.ch8.proxy;

import java.util.Map;

/**
 * @author Lalit Mehra
 *
 */
public class WeatherInformation {

	private String city;
	private double lastFetchedOn;
	private Map<Integer, Integer> temperature;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getLastFetchedOn() {
		return lastFetchedOn;
	}

	public void setLastFetchedOn(double lastFetchedOn) {
		this.lastFetchedOn = lastFetchedOn;
	}

	public Map<Integer, Integer> getTemperature() {
		return temperature;
	}

	public void setTemperature(Map<Integer, Integer> temperature) {
		this.temperature = temperature;
	}

}
