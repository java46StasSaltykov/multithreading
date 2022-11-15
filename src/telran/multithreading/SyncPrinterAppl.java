package telran.multithreading;

import java.util.*;

public class SyncPrinterAppl {
	
	static final int N_PRINTERS = 4;
	static final int N_NUMBERS = 100;
	static final int N_PORTIONS = 10;

	@SuppressWarnings("resource")
	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);
		ArrayList<SyncPrinter> printers = createPrinters(N_PRINTERS);
		
		for (int i = 0; i < N_PRINTERS; i++) {
			if (i == N_PRINTERS - 1) {
				printers.get(i).next = printers.get(0);
			} else {
				printers.get(i).next = printers.get(i + 1);
			}
		}

		printers.stream().forEach(p -> p.start());
		System.out.println("Keep pressing Enter");
		scanner.nextLine();
		printers.get(0).interrupt();
	}

	private static ArrayList<SyncPrinter> createPrinters(int nPrinters) {
		ArrayList<SyncPrinter> printers = new ArrayList<SyncPrinter>();
		for (int i = 0; i < nPrinters; i++) {
			printers.add(new SyncPrinter(String.valueOf(i + 1), N_NUMBERS, N_PORTIONS));
		}
		return printers;
	}
	
}
