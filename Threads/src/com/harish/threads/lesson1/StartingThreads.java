package com.harish.threads.lesson1;

public class StartingThreads {

	public static void main(String[] args) throws InterruptedException {
		
		Thread1 thread1 = new Thread1();
		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread thread = new Thread(new Thread2());
		thread.start();
		Thread.sleep(3500);
		thread.interrupt();
		thread.isInterrupted();
		Thread.interrupted();
				
		
	}

}
