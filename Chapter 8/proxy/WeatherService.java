package edu.bpb.oops.pattern.ch8.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Actual Implementation to fetch weather information
 * 
 * @author Lalit Mehra
 *
 */
public class WeatherService implements Weather {
	
	private WeatherStation ws;
	private String md5;
	
	{
		ws = new WeatherStation();
		md5 = ws.connect("droid", "H6sDg6r8TfRdfv76");
	}

	/**
	 * Returns temperature for every hour for a city. <br>
	 * The method signature does not take into consideration the city name and
	 * returns same value for every input
	 */
	public Map<Integer, Integer> fetchTemperature(String city) {

		Map<Integer, Integer> temperatures = new HashMap<Integer, Integer>(24);

		double token = ws.fetchToken(md5);
		temperatures = ws.fetchTemperature(token, city);
		
		return temperatures;
	}

}
