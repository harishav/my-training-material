package com.harish.threads.lesson1;

public class Thread1 extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("Message from Thread");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
