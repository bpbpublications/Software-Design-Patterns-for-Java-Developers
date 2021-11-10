package edu.bpb.oops.pattern.ch6.adapter.legacy;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Legacy data analyser
 * 
 * @author Lalit Mehra
 *
 */
public interface DataAnalyser {
	
	public void acquire() throws IOException;

	public void save(Map<String, String> data) throws IOException;
	
	public void release() throws IOException; 
	
	public List<String> fetch(List<String> keys) throws IOException;
	
}
