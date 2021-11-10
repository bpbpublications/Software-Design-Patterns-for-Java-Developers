package edu.bpb.oops.pattern.ch8.proxy;

import java.util.Map;

/**
 * Proxy interface acts as binding contract for both the actual and proxy
 * implementation classes <br>
 * used to fetch weather information e.g. temperature
 * 
 * @author Lalit Mehra
 *
 */
public interface Weather {

	/**
	 * Fetches a map of &lttime, temperature&gt. Both are denoted by numbers.<br>
	 * Temperature for every hour is present in the map in 24 hour format.<br>
	 * Key is denoted by time and temperature as values.
	 * 
	 * @param city name of the city
	 * 
	 * @return map of &lttime, temperature&gt
	 */
	public Map<Integer, Integer> fetchTemperature(String city);
}
