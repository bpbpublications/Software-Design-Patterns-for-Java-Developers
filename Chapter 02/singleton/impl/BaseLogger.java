package edu.bpb.oops.pattern.ch2.singleton.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

import edu.bpb.oops.pattern.ch2.singleton.enums.LogLevel;

/**
 * This class demonstrates a basic logger implementation that allows to write logs 
 * to a supplied filepath
 * 
 * @author Lalit Mehra
 */
public class BaseLogger implements Serializable {
	
	private static final long serialVersionUID = -2151244496146139427L;
	
	private String filepath;
	private Writer writer;
	
	private void init() throws IOException {
		writer = new FileWriter(filepath, true);
	}
	
	public BaseLogger(String filepath) throws IOException {
		this.filepath = filepath;
		init();
	}
	
	public void log(String message) throws IOException {
		log(LogLevel.INFO, message);
	}
	
	public void log(LogLevel logLevel, String message) throws IOException {
		writer.append(logLevel.getLogAcronym()).append(message).append(System.lineSeparator());
		writer.flush();
	}
	
}
