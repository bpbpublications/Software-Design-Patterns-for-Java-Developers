package edu.bpb.oops.pattern.ch8.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Provides weather related information
 * 
 * @author Lalit Mehra
 *
 */
public class WeatherInfoProxy implements Weather {

	private Map<Integer, Integer> temperatures;
	
	private WeatherService weatherInfo;
	
	{
		temperatures = null;
		temperatures = new HashMap<Integer, Integer>(24);
		IntStream.rangeClosed(0, 5).forEach((x) -> temperatures.put(x, x+6));
	}
	
	private Map<Integer, Integer> getStoredTemparatureData(String city) {
		return temperatures;
	}

	public Map<Integer, Integer> fetchTemperature(String city) {
		if(weatherInfo != null) {
			return weatherInfo.fetchTemperature(city);
		} else {
			
			/* Initialise Weather Info to fetch data */
			Thread initWeatherInfo = new Thread(() -> {
				/* Loop through to imitate thread sleep */
				IntStream.rangeClosed(0, Integer.MAX_VALUE).forEach((x) -> {});
				
				weatherInfo = new WeatherService();
			});
			initWeatherInfo.start();
			
			return getStoredTemparatureData(city);
		}
	}

}
