package CoreJAVA.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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
        //getting current time in mili seconds
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i=1;i<10;i++){
            int finalI = i;
            Future<?> executor_outcome = executor.submit(()->{
                long result = factorial(finalI);
                System.out.println(result);
            });

            if(executor_outcome.isDone()){
                System.out.println(" Task completed");
            }else if(executor_outcome.isCancelled()){
                System.out.println("Task failed");
            }else{
                System.out.println("Waiting ... ");
            }
        }
        executor.shutdown();

        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(" time took to complete the task > " + (System.currentTimeMillis() - startTime));
    }
}
