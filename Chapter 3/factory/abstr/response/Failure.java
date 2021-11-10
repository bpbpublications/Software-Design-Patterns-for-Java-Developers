package edu.bpb.oops.pattern.ch3.factory.abstr.response;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.abstr.Response;

/**
 * @author Lalit Mehra
 *
 */
public class Failure extends Response {

	public Failure(ProcessResult result) {
		super(result);
	}

	@Override
	public void process() {
		System.out.println("process failure information");
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
