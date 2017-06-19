package com.threads.main.example2;

import java.util.HashMap;
import java.util.Map;

public class Main {
	
	
	
	public static void main(String[] args) {
		Map<Integer, String> processingResult = new HashMap<Integer, String>();
		
		Thread thread1 = new Thread(new Thread1(processingResult), "Thread1");
		thread1.setDaemon(false);
		thread1.start();
		
		Thread thread2 = new Thread(new Thread2(processingResult), "Thread2");
		thread2.setDaemon(false);
		thread2.start();
	}
	
	
}
