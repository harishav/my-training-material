package com.harish.caveOfProgramming;

public class _9_WorkedExampleUsingLowLevelSync {

	public static void main(String[] args) {
		
		final _9_Processor processor = new _9_Processor();

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
