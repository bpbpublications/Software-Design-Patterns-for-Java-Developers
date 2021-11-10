package edu.bpb.oops.pattern.ch3.factory.method.bean;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.method.Response;

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
}
