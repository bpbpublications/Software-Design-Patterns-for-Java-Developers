package edu.bpb.oops.pattern.ch3.factory.method.test;

import edu.bpb.oops.pattern.ch3.factory.Order;
import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.ResponseType;
import edu.bpb.oops.pattern.ch3.factory.method.DefaultResponseGenerator;
import edu.bpb.oops.pattern.ch3.factory.method.FrenchResponseGenerator;
import edu.bpb.oops.pattern.ch3.factory.method.Response;

/**
 * @author Lalit Mehra
 *
 */
public class ResponseTester {
	
	public static void main(String[] args) {
		Order order1 = new Order();
		ProcessResult result1 = new ProcessResult("101", order1 , "200");
		
		Order order2 = new Order();
		ProcessResult result2 = new ProcessResult("102", order2 , "400");
		
		Order order3 = new Order();
		ProcessResult result3 = new ProcessResult("103", order2 , "100");

		DefaultResponseGenerator factory = new DefaultResponseGenerator();
		FrenchResponseGenerator frenchFactory = new FrenchResponseGenerator();
		
		Response resp1 = factory.prepareResponse(result1, ResponseType.SUCCESS);
		System.out.println();
		Response resp2 = frenchFactory.prepareResponse(result2, ResponseType.FAILURE);
		System.out.println();
		Response resp3 = frenchFactory.prepareResponse(result3, ResponseType.TIMEOUT);
		
	}

}