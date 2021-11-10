package edu.bpb.oops.pattern.ch3.factory.abstr.impl;

import edu.bpb.oops.pattern.ch3.factory.Message;
import edu.bpb.oops.pattern.ch3.factory.ProcessResult;
import edu.bpb.oops.pattern.ch3.factory.abstr.Reader;

/**
 * @author Lalit Mehra
 *
 */
public class DefaultReader implements Reader {

	@Override
	public Message read(ProcessResult result) {
		return new Message();
	}

}
