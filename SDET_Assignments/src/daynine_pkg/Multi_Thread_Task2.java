//2. Online Food Delivery System
//Multiple orders processed by limited delivery agents (thread pool).

package daynine_pkg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class OrderTask implements Runnable {

    private int orderId;

    public OrderTask(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println("Order " + orderId + " picked by " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Order " + orderId + " delivered by " + Thread.currentThread().getName());
    }
}

public class Multi_Thread_Task2 {

    public static void main(String[] args) {

        int numberOfAgents = 3; 

       
        ExecutorService pool = Executors.newFixedThreadPool(numberOfAgents);

        
        for (int i = 1; i <= 5; i++) {
            pool.execute(new OrderTask(i)); 
        }

        pool.shutdown();
    }
}
