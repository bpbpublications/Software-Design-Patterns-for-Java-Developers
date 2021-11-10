package edu.bpb.oops.pattern.ch7.decorator.impl;

import edu.bpb.oops.pattern.ch7.decorator.Map;
import edu.bpb.oops.pattern.ch7.decorator.MapDecorator;

/**
 * @author Lalit Mehra
 *
 */
public class TravellerMap extends MapDecorator {

	public TravellerMap(Map map) {
		super(map);
	}

	@Override
	public void draw() {
		super.draw();
		mapUI.printDistance(map.getLocationCoordinates());
		mapUI.printTravelTime(map.getLocationCoordinates());
	}
	
}
