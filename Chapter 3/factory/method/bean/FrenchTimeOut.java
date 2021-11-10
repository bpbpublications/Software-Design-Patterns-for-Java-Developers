package edu.bpb.oops.pattern.ch3.factory.method.bean;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.method.Response;

/**
 * @author Lalit Mehra
 *
 */
public class FrenchTimeOut extends Response {

	public FrenchTimeOut(ProcessResult result) {
		super(result);
	}

	@Override
	public void convert() {
		System.out.println("convert response to french dialect");
	}

}
