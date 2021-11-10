package edu.bpb.oops.pattern.ch3.factory.method.bean;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.abstr.Converter;
import edu.bpb.oops.pattern.ch3.factory.abstr.impl.FrenchDialectConverter;
import edu.bpb.oops.pattern.ch3.factory.method.Response;

/**
 * @author Lalit Mehra
 *
 */
public class FrenchSuccess extends Response {
	
	Converter converter = new FrenchDialectConverter();
	
	public FrenchSuccess(ProcessResult result) {
		super(result);
	}

	@Override
	public void process() {
		System.out.println("process success information");
	}

	@Override
	public void convert() {
		System.out.println("convert response to french dialect");
		response = converter.convert(result.getOrder().getNotes());
	}
	
}
