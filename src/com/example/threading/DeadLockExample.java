package com.example.threading;

public class DeadLockExample {

	public static void main(String[] args) {
		Reference r = new Reference();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try {
					r.levelOneDetails();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					r.levelTwoDetails();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
	}

}

class Reference{
	private final Object levelOneLock = new Object();
	private final Object levelTwoLock = new Object();
	
	
	public String levelOneDetails() throws InterruptedException{
		String msg;
		synchronized(levelOneLock){
			Thread.sleep(100);
			synchronized(levelTwoLock){
				msg = "levelOneDetails";
			}
		}
		return msg;
	}
	
	public String levelTwoDetails() throws InterruptedException{
		String msg;
		synchronized(levelTwoLock){
			Thread.sleep(100);
			synchronized(levelOneLock){
				msg = "levelTwoDetails";
			}
		}
		return msg;
	}
}
