package edu.bpb.oops.pattern.ch7.decorator.impl;

import edu.bpb.oops.pattern.ch7.decorator.Map;
import edu.bpb.oops.pattern.ch7.decorator.MapCoordinates;
import edu.bpb.oops.pattern.ch7.decorator.MapDecorator;

/**
 * @author Lalit Mehra
 *
 */
public class PinnedLocationMap extends MapDecorator {

	public PinnedLocationMap(Map map) {
		super(map);
	}
	
	@Override
	public void draw() {
		super.draw();
		mapUI.pinLocations(map.getLocationCoordinates());
	}
	
	@Override
	public void addLocation(MapCoordinates coordinates) {
		super.addLocation(coordinates);
		mapUI.pinLocations(map.getLocationCoordinates());
	}

}