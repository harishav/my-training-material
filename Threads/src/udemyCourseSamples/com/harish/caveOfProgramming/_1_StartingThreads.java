package com.harish.caveOfProgramming;

import java.util.stream.IntStream;

/**
 * Contains code related to different ways of creating threads
 * 
 * @author harishav
 *
 */
public class _1_StartingThreads {

	public static void main(String[] args) {

		Runner runner = new Runner();
		runner.setName("Runner Thread");
		runner.start();

		Thread thread = new Thread(new Runnabel());
		thread.setName("Runnable Thread");
		thread.start();

		// Java 8 way of doing this
		Thread threadJava8 = new Thread(() -> {

			IntStream.rangeClosed(0, 10).forEach(i -> {
				System.out.println("Thread: " + i + " " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			});

		});
		threadJava8.setName("Java 8 Runnable Thread");
		threadJava8.start();

	}

}

class Runner extends Thread {

	@Override
	public void run() {
		IntStream.rangeClosed(0, 10).forEach(i -> {
			System.out.println("Thread: " + i + " " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		});
	}

}

class Runnabel implements Runnable {

	@Override
	public void run() {
		IntStream.rangeClosed(0, 10).forEach(i -> {
			System.out.println("Thread: " + i + " " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		});

	}

}