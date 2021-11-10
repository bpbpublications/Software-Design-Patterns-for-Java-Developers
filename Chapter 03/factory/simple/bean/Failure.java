package edu.bpb.oops.pattern.ch3.factory.simple.bean;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.simple.Response;

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
}
