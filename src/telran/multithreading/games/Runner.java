package telran.multithreading.games;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Runner extends Thread {
	private Race race;
	private int runnerId;
	private long runningTime;

	public Runner(Race race, int runnerId) {
		this.race = race;
		this.runnerId = runnerId;
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		int sleepRange = race.getMaxSleep() - race.getMinSleep() + 1;
		int minSleep = race.getMinSleep();
		int distance = race.getDistance();
		for (int i = 0; i < distance; i++) {
			try {
				sleep((long) (minSleep + Math.random() * sleepRange));
			} catch (InterruptedException e) {
				throw new IllegalStateException();
			}
			System.out.println(runnerId);
		}
		runningTime = ChronoUnit.MILLIS.between(RaceAppl.startTime, Instant.now());
		race.setWinner(runnerId);
		race.writeResults(runningTime, runnerId);
	}

}
