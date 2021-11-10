package edu.bpb.oops.pattern.ch3.factory.method.bean;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.method.Response;

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

	@Override
	public void convert() {
		System.out.println("conversion not required");
	}

}
