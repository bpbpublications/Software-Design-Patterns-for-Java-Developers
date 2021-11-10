package edu.bpb.oops.pattern.ch3.factory.simple.bean;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.simple.Response;

/**
 * @author Lalit Mehra
 *
 */
public class TimeOut extends Response {

	public TimeOut(ProcessResult result) {
		super(result);
	}

}
