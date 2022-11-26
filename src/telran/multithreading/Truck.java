package telran.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Truck extends Thread {
	private int load;
	private int nLoads;
	private static long elevator1;
	private static long elevator2;
	private static Lock lock = new ReentrantLock();
	private static int count = 0;

	public Truck(int load, int nLoads) {
		this.load = load;
		this.nLoads = nLoads;
	}

	@SuppressWarnings("finally")
	@Override
	public void run() {
		while (true) {
			if (lock.tryLock()) {
				try {
					for (int i = 0; i < nLoads; i++) {
						loadElevator1(load);
						loadElevator2(load);
					}
				} finally {
					lock.unlock();
					break;
				}
			} else {
				count++;
			}
		}
	}

	static private void loadElevator2(int load) {
		elevator2 += load;
	}

	static private void loadElevator1(int load) {
		elevator1 += load;
	}
	

	public static long getElevator1() {
		return elevator1;
	}

	public static long getElevator2() {
		return elevator2;
	}
	
	public static int getWaitingCounter() {
		return count;
	}
}



