package edu.bpb.oops.pattern.ch3.factory.abstr.response;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.abstr.Response;
import edu.bpb.oops.pattern.ch3.factory.abstr.ResponseDialectFactory;

/**
 * @author Lalit Mehra
 *
 */
public class GermanTimeOut extends Response {

	private ResponseDialectFactory factory;

	public GermanTimeOut(ProcessResult result, ResponseDialectFactory factory) {
		super(result);
		this.factory = factory;
	}

	@Override
	public void setup() {
		System.out.println("setup german dialect");
		formatter = factory.getFormatter();
		converter = factory.getConverter();
		reader = factory.getReader();
	}

	@Override
	public void convert() {
		System.out.println("convert response to german dialect");
		converter.convert(result.getOrder().getNotes());
	}

	@Override
	public void read() {
		this.message = reader.read(result);
	}

	@Override
	public void format() {
		System.out.println("convert response to " + formatter.whichFormat());
		response = formatter.format(result.getOrder().getNotes());
	}

}
