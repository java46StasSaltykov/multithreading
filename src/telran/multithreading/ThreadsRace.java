package telran.multithreading;

import java.util.*;

public class ThreadsRace {
	
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Thread> runnerThreads = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Enter number of threads between 2-5");
		int runners = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter distance between 100-3500");
		int distance = scanner.nextInt();
		runnerThreads = getRunners(runners, distance);
		for (Thread thread : runnerThreads) {
			thread.start();
		}
		for (Thread thread : runnerThreads) {
			thread.join();
		}
		getWinner(runnerThreads);
	}


	private static void getWinner(ArrayList<Thread> runnerThreads) {
		TreeSet<Double> results = new TreeSet<Double>(); 
		for (Thread thread : runnerThreads) {
			results.add(((ThreadRunner) thread).getRunningTime());
		}
		double res = results.first();
		int champ = 0;
		for (Thread thread : runnerThreads) {
			if (((ThreadRunner) thread).getRunningTime() == res) {
				champ = ((ThreadRunner) thread).getNumber();
			}
		}
		System.out.println("Congratulations to thread #" + champ);
	}


	private static ArrayList<Thread> getRunners(int numberOfThreads, int distance) {
		ArrayList<Thread> threads = new ArrayList<>();
		Random random = new Random();
		int sleep = random.nextInt(5 - 2 + 1) + 2;
		for (int i = 0; i < numberOfThreads; i++) {
			threads.add(new ThreadRunner(i + 1, distance, sleep));
		}
		return threads;
	}

}

