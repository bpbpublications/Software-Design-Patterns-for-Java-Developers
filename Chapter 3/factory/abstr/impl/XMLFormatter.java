package edu.bpb.oops.pattern.ch3.factory.abstr.impl;

import edu.bpb.oops.pattern.ch3.factory.abstr.Formatter;

/**
 * @author Lalit Mehra
 *
 */
public class XMLFormatter implements Formatter {

	@Override
	public String format(String message) {
		return "";
	}

	@Override
	public String whichFormat() {
		return "XML";
	}

}
