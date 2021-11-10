package edu.bpb.oops.pattern.ch3.factory.simple.bean;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.simple.Response;

/**
 * @author Lalit Mehra
 *
 */
public class Success extends Response {

	public Success(ProcessResult result) {
		super(result);
	}

	@Override
	public void process() {
		System.out.println("process success information");
	}

}
