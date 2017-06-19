package com.threads.main.example1;

public class Thread2 extends Thread {
	
	@Override
	public void run() {
		
		synchronized (this) {
			
			try {
				System.out.println("Thread 2 will sleep for 2 seconds.");
				Thread.sleep(2000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// At the finish of whole process all methods that called the Thread will be notified about the end of the processing.
			notifyAll();
		}
	}
	
}
