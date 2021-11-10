package edu.bpb.oops.pattern.ch3.factory.method;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.ResponseType;

/**
 * @author Lalit Mehra
 *
 */
public abstract class ResponseGenerator {

	public Response prepareResponse(ProcessResult result, ResponseType type) {
		Response resp = construct(result, type);

		resp.read();
		resp.process();
		resp.convert();
		resp.format();

		return resp;
	}
	
	protected abstract Response construct(ProcessResult result, ResponseType type);

}
