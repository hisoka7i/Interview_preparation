package CoreJAVA.MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class DependableService implements Callable<String> {
    public final CountDownLatch latch;

    public DependableService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        // TODO Auto-generated method stub
        try {
            System.out.println("Service Initialized ! ");
            Thread.sleep(2000);
            // return null;
        } finally {
            this.latch.countDown();
        }
        return "ok";
    }
}

public class ExceutorFramework {
    // Iterative method to calculate factorial
    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i; // Multiply result by the current number
        }
        return result;
    }

    public static void main(String[] args) {
        int numberOfServices = 3;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch countdown = new CountDownLatch(numberOfServices); // This latch will be used, to make the main
                                                                         // thread wait

        executor.submit(new DependableService(countdown));
        executor.submit(new DependableService(countdown));
        executor.submit(new DependableService(countdown));

        try {
            countdown.wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            Thread.currentThread().interrupt();
        }


        System.out.println(" Main thread will be executed after all the other threads are done!");
        executor.shutdown();
        /*
         * //getting current time in mili seconds
         * long startTime = System.currentTimeMillis();
         * ExecutorService executor = Executors.newFixedThreadPool(3);
         * 
         * for(int i=1;i<10;i++){
         * int finalI = i;
         * Future<?> executor_outcome = executor.submit(()->{
         * long result = factorial(finalI);
         * System.out.println(result);
         * });
         * 
         * if(executor_outcome.isDone()){
         * System.out.println(" Task completed");
         * }else if(executor_outcome.isCancelled()){
         * System.out.println("Task failed");
         * }else{
         * System.out.println("Waiting ... ");
         * }
         * }
         * executor.shutdown();
         * 
         * try {
         * executor.awaitTermination(100, TimeUnit.SECONDS);
         * } catch (InterruptedException e) {
         * // TODO Auto-generated catch block
         * e.printStackTrace();
         * }
         * System.out.println(" time took to complete the task > " +
         * (System.currentTimeMillis() - startTime));
         */
    }
}
