package com.springpeople.threaddemo;

public class Worker extends Thread{

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i + ", Priority: "
					+ Thread.currentThread().getPriority());
			
			if(i == 3) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
