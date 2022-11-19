package telran.multithreading.games;

import java.util.*;
import java.util.Map.Entry;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	private int winner = -1;
	public static Map<Long, Integer> results;

	public Race(int distance, int minSleep, int maxSleep) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
		results = new TreeMap<Long, Integer>();
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		if (this.winner == -1) {
			this.winner = winner;
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
	
	synchronized public static void writeResults(Long runningTime, Integer runnerId) {
		results.put(runningTime, runnerId);
	}

	public void getResults() {
		int place = 1;
		System.out.print("\nResults:\nplace     racer number      time\n");
		for (Entry<Long, Integer> entry : results.entrySet()) {
			System.out.println(place++ + "           " + entry.getValue() + "               " + entry.getKey());
		}
	}
}
