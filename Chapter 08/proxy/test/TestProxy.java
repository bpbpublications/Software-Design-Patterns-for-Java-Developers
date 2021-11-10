package edu.bpb.oops.pattern.ch8.proxy.test;

import java.util.Map;

import edu.immune.sw.pattern.proxy.Weather;
import edu.immune.sw.pattern.proxy.WeatherService;
import edu.immune.sw.pattern.proxy.WeatherServiceProxy;

/**
 * Functional Test to verify the functionality of Proxy Design Pattern
 * 
 * @author Lalit Mehra
 */
public class TestProxy {
	
	public static void main(String[] args) {
		
		WeatherService weatherService = new WeatherService();
		Weather proxy = new WeatherServiceProxy(weatherService);
		Map<Integer, Integer> tmpr = proxy.fetchTemperature("delhi");
		System.out.printf("::: Temperature of Delhi ::: \n %s \n", tmpr.toString());
		
		Map<Integer, Integer> tmpr2 = proxy.fetchTemperature("mumbai");
		System.out.printf("::: Temperature of Mumbai ::: \n %s \n", tmpr2.toString());
		
		Map<Integer, Integer> tmpr3 = proxy.fetchTemperature("delhi");
		System.out.printf("::: Temperature of Delhi ::: \n %s \n", tmpr3.toString());

	}

}
