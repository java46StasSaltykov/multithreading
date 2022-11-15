package telran.multithreading;

import java.util.Scanner;

public class SyncPrinter extends Thread {
	
	private String symbol;
	private int amount;
	private int portions;
	private int sum;
	public SyncPrinter next;
	private Scanner scanner = new Scanner(System.in);
	
	public SyncPrinter(String symbol, int amount, int portions) {
		this.symbol = symbol;
		this.amount = amount;
		this.portions = portions;
		this.sum = 0;
	}

	@Override
	public void run() {
		while (this.sum < amount) {
			try {
				Thread.sleep(Long.MAX_VALUE);
			} catch (InterruptedException e) {
				System.out.println(symbol.repeat(portions));
				sum += portions;
				scanner.nextLine();
				next.interrupt();
			}
		}
	}


}
