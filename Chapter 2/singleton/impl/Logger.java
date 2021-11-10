package edu.bpb.oops.pattern.ch2.singleton.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.immune.sw.pattern.singleton.enums.LogLevel;

/**
 * This class demonstrates a logger implementation that uses singleton design pattern
 * to ensure that only one instance of the logger is present in the application
 * 
 * @author Lalit Mehra
 */
public class Logger {
	
	private static Logger instance;
	private Map<String, FileWriter> writers;

	private void init() {
		try {
			File file = new File("/Users/Kurama/Documents/log_config.txt");
			Scanner scanner = new Scanner(file);
			writers = new HashMap<>();
			while(scanner.hasNextLine()) {
				String config[] = scanner.nextLine().split(" ");
				writers.put(config[1], new FileWriter(config[0], true));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private Logger() {
		init();
	}
	
	public static Logger getInstance() {
		if(null == instance ) {
			instance = new Logger();
		}
		return instance;
	}
	
	public void log(String logfile, String message) throws IOException {
		log(LogLevel.INFO, logfile, message);
	}
	
	public void log(LogLevel logLevel, String logfile, String message) throws IOException {
		writers.get(logfile).append(logLevel.getLogAcronym()).append(message).append(System.lineSeparator());
		writers.get(logfile).flush();
	}
	
}
