package CoreJAVA.MultiThreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private final Lock lock = new ReentrantLock();
    private int balance = 100;

    public boolean withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is trying to withdraw");
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                if (amount <= balance) {
                    balance -= amount;
                    System.out.println("Amount withdrawn using thread > " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }finally{
                        lock.unlock();
                    }

                } else
                    return false;
            } else {
                System.err.println(Thread.currentThread().getName() + " < This thread failed to acquire lock");
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return true;
    }
}

class CounterObject {
    int count = 0;

    boolean increment() {
        count += 1;
        return true;
    }

    int getCount() {
        return count;
    }
}

public class Threading {
    public static void main(String[] args) throws Exception {
        CounterObject counter_object = new CounterObject();
        Thread thread_one = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter_object.increment();
                try {
                    System.err.println("Thread_one is runnning");
                    Thread.sleep(1000);
                    // Thread.yield();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    Thread.currentThread().interrupt();
                    // e.printStackTrace();
                }
            }
        });
        // current state of a thread
        // System.out.println("Current state of a thread " + thread_one.getState());

        // System.out.println("Current state of a thread " + thread_one.getState());
        // thread_one.interrupt(); //we can interrupt current state of thread using this
        // method
        Thread thread_two = new Thread(() -> {
            // System.out.println("Current state of a thread " + thread_one.getState());
            for (int i = 0; i < 1000; i++) {
                counter_object.increment();
                try {
                    System.out.println("Thread_two is running ");
                    Thread.sleep(1000);
                    // Thread.yield(); //by this method we hint scheduler to give other threads a
                    // chance to complete
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    Thread.currentThread().interrupt();
                    // e.printStackTrace();
                }
            }
        });
        thread_two.start();
        thread_one.start();
        thread_one.interrupt();
        // now threads are running simulation
        Thread deamon_thread = new Thread(() -> {
            while (true) {
                System.out.println("Keep it going!");
            }
        });
        deamon_thread.setDaemon(true);
        // deamon_thread.start(); //JVM did not care for this one to end, since this is
        // a deamon thread
        // we have started two threads
        // thread_one.join();
        // thread_two.join();

        // System.err.println(counter_object.getCount());

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(()->{
        System.out.println(counter_object.getCount());
        if(thread_one.isAlive() == false && thread_two.isAlive() == false){
        scheduler.shutdown();
        }
        }, 0, 1, TimeUnit.SECONDS);

        // Below code is for bank class
        BankAccount hdfc = new BankAccount();
        Thread bank_thread_one = new Thread(() -> {
            hdfc.withdraw(50);
        }, "Thread one");
        Thread bank_thread_two = new Thread(() -> {
            hdfc.withdraw(50);
        }, "Thread two");
        // bank_thread_one.start();
        // bank_thread_two.start();

    }
    // bank_thread_one.
}
