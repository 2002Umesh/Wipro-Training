//4. Bank Account System 
//Multiple threads deposit and withdraw from same account safely.

package daynine_pkg;

class BankAccount {
    private int balance = 1000;

    
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " depositing " + amount);
        balance += amount;
        System.out.println("Balance after deposit: " + balance);

        notifyAll(); 
    }

   
    public synchronized void withdraw(int amount) {
        while (balance < amount) {
            System.out.println(Thread.currentThread().getName() + " waiting to withdraw " + amount);
            try {
                wait(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " withdrawing " + amount);
        balance -= amount;
        System.out.println("Balance after withdrawal: " + balance);
    }
}


class TransactionTask implements Runnable {

    private BankAccount account;
    private String type;
    private int amount;

    public TransactionTask(BankAccount account, String type, int amount) {
        this.account = account;
        this.type = type;
        this.amount = amount;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            if (type.equals("deposit")) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Multi_Thread_Task4 {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Runnable depositTask = new TransactionTask(account, "deposit", 500);
        Runnable withdrawTask1 = new TransactionTask(account, "withdraw", 700);
        Runnable withdrawTask2 = new TransactionTask(account, "withdraw", 400);

        new Thread(depositTask, "Depositor").start();
        new Thread(withdrawTask1, "Withdrawer-1").start();
        new Thread(withdrawTask2, "Withdrawer-2").start();
    }
}