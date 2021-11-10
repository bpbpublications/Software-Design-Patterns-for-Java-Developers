package edu.bpb.oops.pattern.ch3.factory.simple.test;

import edu.bpb.oops.pattern.ch3.factory.Order;
import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.ResponseType;
import edu.bpb.oops.pattern.ch3.factory.simple.Response;
import edu.bpb.oops.pattern.ch3.factory.simple.ResponseGenerator;

/**
 * @author Lalit Mehra
 *
 */
public class ResponseTester {
	
	public static void main(String[] args) {
		ResponseGenerator generator = new ResponseGenerator();
		
		Order order1 = new Order();
		ProcessResult result1 = new ProcessResult("101", order1 , "200");
		
		Order order2 = new Order();
		ProcessResult result2 = new ProcessResult("102", order2 , "400");
		
		Order order3 = new Order();
		ProcessResult result3 = new ProcessResult("103", order3 , "100");
		
		Response resp1 = generator.prepareResponse(result1, ResponseType.SUCCESS);
		System.out.println();
		Response resp2 = generator.prepareResponse(result2, ResponseType.FAILURE);
		System.out.println();
		Response resp3 = generator.prepareResponse(result3, ResponseType.TIMEOUT);
		
	}

}