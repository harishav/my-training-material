package com.harish.threads.lesson1;

public class Thread2 implements Runnable{

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Message from Runnable Thread: "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}
		
	}

}
