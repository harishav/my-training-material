package com.harish.caveOfProgramming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processer implements Runnable {

	private int id;

	public Processer(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting: " + id);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Completed: " + id);

	}

}

/**
 * Explains the usage of Thread Pools using ExecutorService
 * @author harishav
 *
 */
public class _5_ThreadPools {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; i++) {
			executor.submit(new Processer(i));
		}

		executor.shutdown();

		System.out.println("All tasks submitted....");

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
