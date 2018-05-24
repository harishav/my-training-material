package com.harish.caveOfProgramming;

public class _8_WaitAndNotify {

	public static void main(String[] args) {
		
		final _8_Processor processor = new _8_Processor();

		Thread t1 = new Thread(() -> {
			try {
				processor.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				processor.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
