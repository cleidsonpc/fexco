package com.threads.main.example1;

public class Thread1 implements Runnable {

	@Override
	public void run() {

		try {
			Thread t2 = new Thread(new Thread2());
			
			// this block synchronize the thread 2 with thread 1 to use a wait method.
			synchronized (t2) {
				t2.start();
				
//				t2.wait(); // Wait the end of the Thread 2.
				t2.join(); // Wait for the call of notify method, different from wait that release the processing after the notify().
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread 1 finished.");
	}

}
