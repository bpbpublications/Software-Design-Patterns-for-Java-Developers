package edu.bpb.oops.pattern.ch8.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Lalit Mehra
 *
 */
public class WeatherStation {
	
	private static Random random;

	static {
		random = new Random();
	}
	
	public String connect(String uname, String pass) {
		return "md5";
	}
	
	public double fetchToken(String md5) {
		return random.nextDouble();
	}
	
	/**
	 * Returns temperature for every hour for a city. <br>
	 * The method signature does not take into consideration the city name and
	 * returns same value for every input
	 */
	public Map<Integer, Integer> fetchTemperature(double token, String city) {

		Map<Integer, Integer> temperatures = new HashMap<Integer, Integer>(24);

		/* fill temperature in the map randomly within the range of 1 and 20 */
		IntStream.rangeClosed(0, 23).forEach((x) -> temperatures.put(x, random.nextInt(20)));
		return temperatures;
	}

}
