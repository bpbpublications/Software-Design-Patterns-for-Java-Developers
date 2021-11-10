package edu.bpb.oops.pattern.ch3.factory.simple;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.ResponseType;

/**
 * @author Lalit Mehra
 *
 */
public class ResponseGenerator {

	private ResponseFactory factory = new ResponseFactory();

	public Response prepareResponse(ProcessResult result, ResponseType type) {
		Response resp = factory.construct(result, type);

		resp.read();
		resp.process();
		resp.format();

		return resp;
	}

}
