package com.harish.caveOfProgramming;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor6 implements Runnable{

	private CountDownLatch latch;
	
	public Processor6(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		
		System.out.println("Started...");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		latch.countDown();
	}
	
}

public class _6_CountDownLatches {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		for(int i=0; i<3; i++) {
			executorService.submit(new Processor6(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed....");
		
	}

}
