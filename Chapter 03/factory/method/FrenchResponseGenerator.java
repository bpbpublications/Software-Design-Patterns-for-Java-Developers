package edu.bpb.oops.pattern.ch3.factory.method;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.ResponseType;
import edu.bpb.oops.pattern.ch3.factory.method.bean.FrenchFailure;
import edu.bpb.oops.pattern.ch3.factory.method.bean.FrenchSuccess;
import edu.bpb.oops.pattern.ch3.factory.method.bean.FrenchTimeOut;

/**
 * @author Lalit Mehra
 *
 */
public class FrenchResponseGenerator extends ResponseGenerator {

	public Response construct(ProcessResult result, ResponseType type) {
		Response resp = null;
		switch (type) {
		case SUCCESS:
			resp = new FrenchSuccess(result);
			break;
		case FAILURE:
			resp = new FrenchFailure(result);
			break;
		case TIMEOUT:
			resp = new FrenchTimeOut(result);
			break;
		default:
			break;
		}
		return resp;
	}

}
