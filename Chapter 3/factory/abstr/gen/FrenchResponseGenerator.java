package edu.bpb.oops.pattern.ch3.factory.abstr.gen;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.ResponseType;
import edu.bpb.oops.pattern.ch3.factory.abstr.Response;
import edu.bpb.oops.pattern.ch3.factory.abstr.ResponseDialectFactory;
import edu.bpb.oops.pattern.ch3.factory.abstr.ResponseGenerator;
import edu.bpb.oops.pattern.ch3.factory.abstr.dialect.FrenchDialectFactory;
import edu.bpb.oops.pattern.ch3.factory.abstr.response.FrenchFailure;
import edu.bpb.oops.pattern.ch3.factory.abstr.response.FrenchSuccess;
import edu.bpb.oops.pattern.ch3.factory.abstr.response.FrenchTimeOut;

/**
 * @author Lalit Mehra
 *
 */
public class FrenchResponseGenerator extends ResponseGenerator {
	
	private ResponseDialectFactory dialect = new FrenchDialectFactory();

	public Response construct(ProcessResult result, ResponseType type) {
		Response resp = null;
		switch (type) {
		case SUCCESS:
			resp = new FrenchSuccess(result, dialect);
			break;
		case FAILURE:
			resp = new FrenchFailure(result, dialect);
			break;
		case TIMEOUT:
			resp = new FrenchTimeOut(result, dialect);
			break;
		default:
			break;
		}
		return resp;
	}

}
