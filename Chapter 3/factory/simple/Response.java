package edu.bpb.oops.pattern.ch3.factory.simple;

import edu.bpb.oops.pattern.ch3.factory.Message;
import edu.bpb.oops.pattern.ch3.factory.ProcessResult;

/**
 * @author Lalit Mehra
 *
 */
public abstract class Response {
	
	protected Message message;
	protected ProcessResult result;
	
	protected Response(ProcessResult result) {
		this.result = result;
		this.message = new Message();
	}
	
	public void read() {
		message.extract(result);
	}

	public void process() {
		System.out.println("process data before formatting");
	}
	
	public void format() {
		System.out.println("convert response to json format");
	}

}
