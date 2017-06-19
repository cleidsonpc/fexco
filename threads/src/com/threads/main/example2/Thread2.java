package com.threads.main.example2;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Thread2 extends ThreadCommons implements Runnable {
	
	private Map<Integer, String> processResult;
	
	public Thread2(final Map<Integer, String> processResult) {
		this.processResult = processResult;
	}
	
	@Override
	public void run() {
		
		super.waitInSeconds(5);
		
		System.out.println("Starting the Thread2");
		Set<Entry<Integer, String>> list = null;
		
		while(!processResult.isEmpty()) {
			list = processResult.entrySet();
			
			System.out.println("Processing and removing " + list.iterator().next().getValue());
			processResult.remove(list.iterator().next().getKey());
			
			super.waitInSeconds(2);
		}
		
		System.out.println("Finishing the Thread2");
	}
	
}
