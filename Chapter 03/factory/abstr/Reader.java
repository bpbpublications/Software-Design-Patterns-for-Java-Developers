package edu.bpb.oops.pattern.ch3.factory.abstr;

import edu.bpb.oops.pattern.ch3.factory.Message;
import edu.bpb.oops.pattern.ch3.factory.ProcessResult;

/**
 * @author Lalit Mehra
 *
 */
public interface Reader {

	public Message read(ProcessResult result);
	
}
