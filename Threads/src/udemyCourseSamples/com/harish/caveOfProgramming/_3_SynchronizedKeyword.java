package com.harish.caveOfProgramming;

/**
 * Demonstrates the usage of {@code synchronized} keyword
 * @author harishav
 *
 */
public class _3_SynchronizedKeyword {

	private int count = 0;
	
	public synchronized void increment() {
		count++;
	}
	
	public static void main(String[] args) {
		_3_SynchronizedKeyword app = new _3_SynchronizedKeyword();
		app.doWork();
	}

	public void doWork() {

		Thread t1 = new Thread( () ->  {
			for(int i=0; i<10000; i++) {
				increment();
			}
		});
		Thread t2 = new Thread( () ->  {
			for(int i=0; i<10000; i++) {
				increment();
			}
		});
		
		t1.start();
		t2.start();
		
		/*if we do not join, then the o/p would be 0 because the start methods will run and 
		 * immediately the sysout will be executed 
		 * but by that time the loops wouldn't have even started.*/
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Count is: " + count);
		
	}
}
