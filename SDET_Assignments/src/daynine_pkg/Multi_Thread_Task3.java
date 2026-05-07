//3. Print A B C in Sequence
//Three threads print A, B, C repeatedly in order (ABCABC…).

package daynine_pkg;

public class Multi_Thread_Task3 implements Runnable {

	static int count = 1;
	static final Object lock = new Object();

	public void run() {
		while (count <= 20) {
			synchronized (lock) {
				if (count % 3 == 1 && Thread.currentThread().getName().equals("A")) {
					System.out.print("A ");
					count++;
					lock.notifyAll();
				} else if (count % 3 == 2 && Thread.currentThread().getName().equals("B")) {
					System.out.print("B ");
					count++;
					lock.notifyAll();
				} else if (count % 3 == 0 && Thread.currentThread().getName().equals("C")) {
					System.out.print("C ");
					count++;
					lock.notifyAll();
				} else {
					try {
						lock.wait();

					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}

		}

	}

	public static void main(String[] args) {

		Runnable task = new Multi_Thread_Task3();

		new Thread(task, "A").start();
		new Thread(task, "B").start();
		new Thread(task, "C").start();

	}

}
