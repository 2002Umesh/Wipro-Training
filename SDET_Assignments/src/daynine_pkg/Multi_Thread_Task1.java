//1. Alternate Printing (Even-Odd)
//Create two threads: one prints even numbers, another prints odd numbers (1–100) in
//sequence. 

package daynine_pkg;

class NumberPrinter {
	private int number = 1;
	private final int limit = 10;

	public synchronized void printOdd() {
		while (number <= limit) {
			if (number % 2 == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Odd: " + number);
				number++;
				notify();
			}
		}
	}

	public synchronized void printEven() {
		while (number <= limit) {
			if (number % 2 != 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Even: " + number);
				number++;
				notify();
			}
		}
	}
}

class OddThread extends Thread {
	private NumberPrinter printer;

	public OddThread(NumberPrinter printer) {
		this.printer = printer;
	}

	public void run() {
		printer.printOdd();
	}
}

class EvenThread extends Thread {
	private NumberPrinter printer;

	public EvenThread(NumberPrinter printer) {
		this.printer = printer;
	}

	public void run() {
		printer.printEven();
	}
}

public class Multi_Thread_Task1 {

	public static void main(String[] args) {
		NumberPrinter printer = new NumberPrinter();

		OddThread t1 = new OddThread(printer);
		EvenThread t2 = new EvenThread(printer);

		t1.start();
		t2.start();

	}

}
