package telran.multithreading;

public class Printer extends Thread {
	
	private static final long TIMEOUT = 2000;
	private String symbols;
	private boolean running = true;
	
	public Printer(String symbols) {
		this.symbols = symbols;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		int length = symbols.length();
		int index = 0;
		while (running) {
			System.out.println(symbols.charAt(index));
			try {
				sleep(TIMEOUT);
			} catch (InterruptedException e) {
				index++;
				if (index == length) {
					index = 0;
				}
			}
		}
	}
	
}
