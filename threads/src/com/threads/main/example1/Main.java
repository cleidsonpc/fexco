package com.threads.main.example1;

public class Main {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Thread1());
		t1.start();

		System.out.println("After called the Thread1.");
	}
}
