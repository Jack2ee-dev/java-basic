package java_basic.ch12_Thread;

public class ThreadEx24 {
    
    public static void main(String[] args) {
        Runnable r = new RunnableEx24();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        
        t1.start();
        t2.start();
    }
}

class Account {
    
    int balance = 1000;
    
    public synchronized void withdraw(int money) {
        while (balance < money) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        balance -= money;
    }
    
    public synchronized void deposit(int money) {
        balance += money;
        notify();
    }
}

class RunnableEx24 implements Runnable {
    
    Account acc = new Account();
    
    @Override
    public void run() {
        while (acc.balance > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance:" + acc.balance);
        }
    }
}
