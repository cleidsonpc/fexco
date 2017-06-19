package com.threads.main.example2;

import java.util.Map;

public class Thread1 extends ThreadCommons implements Runnable {
	
	private Map<Integer, String> processResult;
	
	public Thread1(final Map<Integer, String> processResult) {
		this.processResult = processResult;
	}
	
	@Override
	public void run() {
		
		int count = 1;
		boolean aux = true;
		
		System.out.println("Starting the Thread1");
		
		while(aux) {
			if(count <= 10) {
				System.out.println("Adding obj-" + count);
				processResult.put(count, "obj-" + count);
				count++;
			} else {
				aux = false;
			}
			
			super.waitInSeconds(1);
		}
		
		System.out.println("Finishing the Thread1");
	}

	public Map<Integer, String> getProcessingResult() {
		return processResult;
	}
}

