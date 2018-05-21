package com.harish.caveOfProgramming;

import java.util.Scanner;

/**
 * Thread caching can be avoided using {@code volatile} keyword
 * @author harishav
 *
 */
class Processor extends Thread {

	private volatile boolean running = true;

	@Override
	public void run() {
		
		while (running) {
			System.out.println("Hello");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}

}

public class _2_BasicThreadSynchronization {

	public static void main(String[] args) {

		Processor proc1 = new Processor();

		proc1.start();

		System.out.println("Press enter to stop .....");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		proc1.shutdown();

		scanner.close();
	}

}
