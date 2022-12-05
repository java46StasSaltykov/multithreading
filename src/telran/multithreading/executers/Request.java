package telran.multithreading.executers;

import java.util.concurrent.atomic.AtomicInteger;

public class Request implements Runnable {
	
	long timeot;
	public static AtomicInteger requestsCounter = new AtomicInteger(0); 

	public Request(long timeot) {
		this.timeot = timeot;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeot);
			requestsCounter.incrementAndGet();
		} catch (InterruptedException e) {

		}
	}
	
	public static int getRequestCounter() {
		return requestsCounter.get();
	}
}
