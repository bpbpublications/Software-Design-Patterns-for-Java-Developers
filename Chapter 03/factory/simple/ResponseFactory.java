package edu.bpb.oops.pattern.ch3.factory.simple;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.ResponseType;
import edu.bpb.oops.pattern.ch3.factory.simple.bean.Failure;
import edu.bpb.oops.pattern.ch3.factory.simple.bean.Success;
import edu.bpb.oops.pattern.ch3.factory.simple.bean.TimeOut;

/**
 * @author Lalit Mehra
 *
 */
public class ResponseFactory {

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
