package edu.bpb.oops.pattern.ch7.decorator;

import java.util.List;

/**
 * @author Lalit Mehra
 *
 */
public class MapUI {
	
	private static MapUI mapUI = new MapUI();
	
	public static MapUI getInstance() {
		return mapUI;
	}
	
	public void drawShortestPath(List<MapCoordinates> coordinates) {
		System.out.println("draw shortest path on the map");
	}
	
	public void addLocation(MapCoordinates coordinates) {
		System.out.println("add location marker to the map");
	}
	
	public void pinLocations(List<MapCoordinates> coordinates) {
		System.out.println("place location markers on the map");
	}
	
	public void printDistance(List<MapCoordinates> coordinates) {
		System.out.println("display distance on the map");
	}
	
	public void printTravelTime(List<MapCoordinates> coordinates) {
		System.out.println("display travel time on the map");
	}

}
