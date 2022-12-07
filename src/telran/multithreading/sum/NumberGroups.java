package telran.multithreading.sum;

import java.util.concurrent.*;

public class NumberGroups {
	
	private int[][] groups;
	private int nThreads = 4;
	
	public NumberGroups(int[][] groups) {
		this.groups = groups;
	}
	
	public long computeSum() throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		long res = 0;
		for (int[] group : groups) {
			OneGroupSum groupSum = new OneGroupSum(group);
			executor.execute(groupSum);
			Thread.sleep(10);
			res += groupSum.getRes();
		}
		return res;
	}

	public int getnThreads() {
		return nThreads;
	}

	public void setnThreads(int nThreads) {
		if (nThreads > 0) {
			this.nThreads = nThreads;
		} else {
			throw new IllegalArgumentException("Should be a positive number of threads.");
		}
	}
	
}
