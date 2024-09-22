package CoreJAVA.MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocking {
    private int count = 0;

    //creating a read/write object
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    //creating a readlock for the class
    private final Lock readLock = lock.readLock();
    //creating a write lock for the class
    private final Lock writeLock = lock.writeLock();

    //a function for write operation
    public void increment(){
        writeLock.lock();
        try{
            count++;
        }finally{
            writeLock.unlock();
        }
    }

    //a function for read operation
    public int getCount(){
        readLock.lock();
        try{
            return count;
        }finally{
            readLock.unlock();
        }
    }
    public static void main(String[] args) {
        ReadWriteLocking counter = new ReadWriteLocking();
        //we are making 2 runnables one for read and one for write
        Runnable readRunnable = new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName() + " > " + counter.getCount());
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run(){
                for(int i=0;i<10;i++){
                counter.increment();
                System.out.println("Count increatment by thread name >" + Thread.currentThread().getName());
                }
            }
        };

        Thread writeThread = new Thread(writeRunnable);
        Thread readThread = new Thread(readRunnable);
        Thread readThread2 = new Thread(readRunnable);

        writeThread.start();
        readThread.start();
        readThread2.start();

        
    }
}
