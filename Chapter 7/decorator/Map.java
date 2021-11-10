package edu.bpb.oops.pattern.ch7.decorator;

import java.util.List;

/**
 * @author Lalit Mehra
 *
 */
public interface Map {
	
	public List<MapCoordinates> getLocationCoordinates();
	
	public void draw();
	
	public void addLocation(MapCoordinates coordinates);
	
}
