package telran.multithreading;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class ThreadRunner extends Thread {

	private int number;
	private int distance;
	private int sleep;
	private double runningTime;

	public ThreadRunner(int number, int distance, int sleep) {
		this.number = number;
		this.distance = distance;
		this.sleep = sleep;
		this.runningTime = 0;
	}

	public int getNumber() {
		return this.number;
	}

	public double getRunningTime() {
		return this.runningTime;
	}

	@Override
	public void run() {
		Instant start = Instant.now();
		for (int i = 0; i < distance; i++) {
			try {
				sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.number);
			runningTime = (double) ChronoUnit.MILLIS.between(start, Instant.now());
		}
		System.out.println("Number " + this.number + " finished with time " + runningTime);
	}
	
}
