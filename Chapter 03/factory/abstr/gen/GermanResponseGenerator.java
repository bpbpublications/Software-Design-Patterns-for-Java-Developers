package edu.bpb.oops.pattern.ch3.factory.abstr.gen;

import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.ResponseType;
import edu.bpb.oops.pattern.ch3.factory.abstr.Response;
import edu.bpb.oops.pattern.ch3.factory.abstr.ResponseDialectFactory;
import edu.bpb.oops.pattern.ch3.factory.abstr.ResponseGenerator;
import edu.bpb.oops.pattern.ch3.factory.abstr.dialect.GermanDialectFactory;
import edu.bpb.oops.pattern.ch3.factory.abstr.response.GermanFailure;
import edu.bpb.oops.pattern.ch3.factory.abstr.response.GermanSuccess;
import edu.bpb.oops.pattern.ch3.factory.abstr.response.GermanTimeOut;

/**
 * @author Lalit Mehra
 *
 */
public class GermanResponseGenerator extends ResponseGenerator {

	private ResponseDialectFactory dialect = new GermanDialectFactory();

	public Response construct(ProcessResult result, ResponseType type) {
		Response resp = null;
		switch (type) {
		case SUCCESS:
			resp = new GermanSuccess(result, dialect);
			break;
		case FAILURE:
			resp = new GermanFailure(result, dialect);
			break;
		case TIMEOUT:
			resp = new GermanTimeOut(result, dialect);
			break;
		default:
			break;
		}
		return resp;
	}

	public static void main(String[] args) {
		try {
			Float f1 = new Float("3.0");
			int x = f1.intValue();
			byte b = f1.byteValue();
			double d = f1.doubleValue();
			System.out.println(x + b + d);
		} catch (NumberFormatException e) {
			System.out.println("bad number");
		}
	}

}
