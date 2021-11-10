package edu.bpb.oops.pattern.ch6.adapter.legacy;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Lalit Mehra
 *
 */
public class FileIODataAnalyser implements DataAnalyser {

	static {
		// connect to the File IO
	}
	
	@Override
	public void acquire() throws IOException {
		System.out.println("Permission acquired!");
	}

	@Override
	public void save(Map<String, String> data) throws IOException {
		System.out.println("Data saved successfully for analysis");
	}

	@Override
	public void release() throws IOException {
		System.out.println("Permission released!");
	}

	@Override
	public List<String> fetch(List<String> keys) throws IOException {
		List<String> data = FileBasedDataAnalyser.fetch(keys);
		System.out.println("Data fetched successfully for analysis");
		return data;
	}

}
