package telran.multithreading.sum;

import java.util.Arrays;

public class OneGroupSum implements Runnable {
	
	private int[] group;
	private Long res = 0L;
	
	public OneGroupSum(int[] group) {
		this.group = group;
	}

	@Override
	public void run() {
		res = (long) Arrays.stream(group).sum();
	}

	public Long getRes() {
		return res;
	}

}
