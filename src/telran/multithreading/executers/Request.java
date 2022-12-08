package telran.multithreading.executers;

import java.util.concurrent.atomic.AtomicInteger;

public class Request implements Runnable {
	long timeout;
	static AtomicInteger requestCounter = new AtomicInteger(0);

	static public int getRequestCounter() {
		return requestCounter.get();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeout);
			requestCounter.incrementAndGet();
		} catch (InterruptedException e) {

		}

	}

	public Request(long timeout) {
		super();
		this.timeout = timeout;
	}

}
