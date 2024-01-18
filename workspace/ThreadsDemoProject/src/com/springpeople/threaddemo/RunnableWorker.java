package com.springpeople.threaddemo;

public class RunnableWorker { //implements Runnable{

//	@Override
//	public void run() {
////		for(int i = 0; i < 5; i++) {
////			System.out.println(Thread.currentThread().getName() + ": " + i);
////			
//////			Thread thread = Thread.currentThread();
//////			if(i == 2) {
//////				if(thread.getName() == "Thread-0") {
//////					try {
//////						wait();
//////					} catch (InterruptedException e) {
//////						System.out.println(e.getMessage());
//////					}
//////				}
//////				
//////			}
////		}
//		
//	}

	private int counter = 0;
	
	public synchronized void method1() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Thread: " + Thread.currentThread().getName() + ": " + i);
			
			if(i == 2) {
				System.out.println("Invoking wait()");
				counter = 2;
				try {
					wait();
//					System.out.println(Thread.currentThread().getState().name());
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public synchronized void method2() {
		
		if(counter == 2) {
			try {
				System.out.println("Going to sleep");
//				System.out.println(Thread.currentThread().getState().name());
				Thread.sleep(3000);
				System.out.println("Now awake");
				
				notify();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
