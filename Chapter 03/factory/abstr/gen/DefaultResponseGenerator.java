package edu.bpb.oops.pattern.ch3.factory.abstr.gen;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.ResponseType;
import edu.bpb.oops.pattern.ch3.factory.abstr.Response;
import edu.bpb.oops.pattern.ch3.factory.abstr.ResponseGenerator;
import edu.bpb.oops.pattern.ch3.factory.abstr.response.Failure;
import edu.bpb.oops.pattern.ch3.factory.abstr.response.Success;
import edu.bpb.oops.pattern.ch3.factory.abstr.response.TimeOut;

/**
 * @author Lalit Mehra
 *
 */
public class DefaultResponseGenerator extends ResponseGenerator {

	public Response construct(ProcessResult result, ResponseType type) {
		Response resp = null;
		switch (type) {
		case SUCCESS:
			resp = new Success(result);
			break;
		case FAILURE:
			resp = new Failure(result);
			break;
		case TIMEOUT:
			resp = new TimeOut(result);
			break;
		default:
			break;
		}
		return resp;
	}

}
