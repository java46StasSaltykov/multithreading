package telran.multithreading.sum;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import org.junit.jupiter.api.Test;

class NumbersGroupTest {
	
	private static final long SIZE = 1000;
	private static final int MIN = 1;
	private static final int MAX = 10000;
	
	private int[][] ar1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

	@Test
	void functionalTest() throws InterruptedException {
		NumberGroups groups = new NumberGroups(ar1);
		long res = groups.computeSum();
		assertEquals(45, res);
	}
	
	@Test
	void performanceTest() throws InterruptedException {	
		NumberGroups groups = new NumberGroups(getGroups());
//		groups.setnThreads(5);
//		groups.setnThreads(10);
		groups.setnThreads(20);
		long performance = groups.computeSum();
	}

	int[][] getGroups() {
		int[][] res = new int[(int) SIZE][(int) SIZE];
		for (int i = 0; i < SIZE; i++) {
			res[i] = new Random().ints(SIZE, MIN, MAX).toArray();
		}
		return res;
	}

}
