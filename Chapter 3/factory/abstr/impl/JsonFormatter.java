package edu.bpb.oops.pattern.ch3.factory.abstr.impl;

import edu.bpb.oops.pattern.ch3.factory.abstr.Formatter;

/**
 * @author Lalit Mehra
 *
 */
public class JsonFormatter implements Formatter {

	@Override
	public String format(String message) {
		return "";
	}

	@Override
	public String whichFormat() {
		return "JSON";
	}

}
