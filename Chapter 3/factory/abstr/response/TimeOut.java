package edu.bpb.oops.pattern.ch3.factory.abstr.response;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.abstr.Response;

/**
 * @author Lalit Mehra
 *
 */
public class TimeOut extends Response {

	public TimeOut(ProcessResult result) {
		super(result);
	}

	@Override
	public void convert() {
		System.out.println("conversion not required");
	}

	@Override
	public void setup() {
		System.out.println("setup not required");
	}

}
