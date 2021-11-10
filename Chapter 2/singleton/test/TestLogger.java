package edu.bpb.oops.pattern.ch2.singleton.test;

import java.io.IOException;

import edu.bpb.oops.pattern.ch2.singleton.enums.LogLevel;
import edu.bpb.oops.pattern.ch2.singleton.impl.BaseLogger;

public class TestLogger {

	public static void main(String[] args) throws IOException {
		TestLogger testSingleton = new TestLogger();
		testSingleton.testLogger(testSingleton);
	}
	
	private void testLogger(TestLogger obj) {
		String filepath = "/Users/Kurama/Documents/log.log";

		Runnable run1 = () -> obj.runFirstLogger(filepath, 50);
		Runnable run2 = () -> obj.runSecondLogger(filepath, 60);
		Runnable run3 = () -> obj.runThirdLogger(filepath, 80);

		new Thread(run1).start();
		new Thread(run2).start();
		new Thread(run3).start();
	}

	private void runFirstLogger(String filepath, int times) {
		for (int count = 0; count < times; count++) {
			try {
				BaseLogger logger = new BaseLogger(filepath);
				logger.log(LogLevel.INFO, "INFO Message ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void runSecondLogger(String filepath, int times) {
		for (int count = 0; count < times; count++) {
			try {
				BaseLogger logger = new BaseLogger(filepath);
				logger.log(LogLevel.DEBUG, "DEBUG Message ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void runThirdLogger(String filepath, int times) {
		for (int count = 0; count < times; count++) {
			try {
				BaseLogger logger = new BaseLogger(filepath);
				logger.log(LogLevel.WARNING, "WARN Message ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
