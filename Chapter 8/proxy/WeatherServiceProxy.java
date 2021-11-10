package edu.bpb.oops.pattern.ch8.proxy;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides weather related information
 * 
 * @author Lalit Mehra
 *
 */
public class WeatherServiceProxy implements Weather {

	private Map<String, WeatherInformation> temperatures = new HashMap<>();
	private double timeWindow = 600000;
	private WeatherService weatherService;
	
	public WeatherServiceProxy(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	public Map<Integer, Integer> fetchTemperature(String city) {
		double currentTime = Calendar.getInstance().getTimeInMillis();
		WeatherInformation weinfo = temperatures.get(city);
		Map<Integer, Integer> temperature;
		
		if(null == weinfo) {
			System.out.println("first call | sending request to weather system");
			WeatherInformation info = new WeatherInformation();
			info.setCity(city);
			temperature = weatherService.fetchTemperature(city);
			info.setTemperature(temperature);
			info.setLastFetchedOn(currentTime);
			temperatures.put(city, info);
		} else if(currentTime > weinfo.getLastFetchedOn() + timeWindow) {
			System.out.println("time window  breached | sending request to weather system");
			temperature = weatherService.fetchTemperature(city);
			weinfo.setTemperature(temperature);
			weinfo.setLastFetchedOn(currentTime);
		} else {
			System.out.println("time window intact | utilizing cached information");
			temperature = weinfo.getTemperature();
		}
		
		return temperatures.get(city).getTemperature();
	}

}
