package edu.bpb.oops.pattern.ch3.factory.method;

import edu.bpb.oops.pattern.ch3.factory.Message;
import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.abstr.Formatter;
import edu.bpb.oops.pattern.ch3.factory.abstr.impl.JsonFormatter;

/**
 * @author Lalit Mehra
 *
 */
public abstract class Response {
	
	protected Message message;
	protected ProcessResult result;
	
	protected Formatter formatter;
	protected String response;
	
	protected Response(ProcessResult result) {
		this.result = result;
		this.message = new Message();
		this.formatter = new JsonFormatter();
	}
	
	public void read() {
		message.extract(result);
	}

	public void process() {
		System.out.println("process data before formatting");
	}
	
	public abstract void convert();
	
	public void format() {
		System.out.println("convert response to json format");
		formatter.format(response);
	}

}
