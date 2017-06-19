package com.threads.main.example2;

public class ThreadCommons {
	public static void waitInSeconds(final long seconds) {
		long miliseconds = seconds * 1000;
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
