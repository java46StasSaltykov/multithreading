package telran.multithreading.games;

import java.util.concurrent.atomic.AtomicInteger;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	private AtomicInteger winner = new AtomicInteger();

	public Race(int distance, int minSleep, int maxSleep) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
	}

	public int getWinner() {
		return winner.get();
	}

	public void setWinner(int winner) {
		if (this.winner.get() == 0) {
			this.winner.addAndGet(winner);
		}
	}

	public int getDistance() {
		return distance;
	}

	public int getMinSleep() {
		return minSleep;
	}

	public int getMaxSleep() {
		return maxSleep;
	}

}
