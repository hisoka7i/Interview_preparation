package CoreJAVA.MultiThreading;

public class ThreadCommunication {
    private int data;
    private boolean hasData = false; // Indicates if there's data to consume

    //// Synchronized func for producing data
    public synchronized void produce(int data) throws InterruptedException{
        //if there is data then, producer will wait for the consumer to consume it
        while(hasData){
            wait();
        }
        this.data = data;
        System.out.println("Producer current data " + this.data);
        this.hasData = true;
        notify(); //This will notify the consumer that data is now present
    }

    //a syncronised method for consuming data
    public synchronized void consume() throws InterruptedException{
        //if there is no data then we will wait for producer to produce data
        while (!hasData) {
            wait();
        }
        System.out.println("Consumed data > " + this.data);
        this.hasData = false;
        notify();
    }

    public static void main(String[] args) {
        ThreadCommunication resource = new ThreadCommunication();

        Thread producer = new Thread(()->{
            for(int i=1;i<=5;i++){
                try{
                    resource.produce(i*100);
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
            }
        }, "Producer Thread");

        Thread consumer = new Thread(()->{
            for(int i=1;i<5;i++){
                try {
                    resource.consume();
                    Thread.sleep(1500); //after production, consumption should happen
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    Thread.currentThread().interrupt();
                }
            }
        },"Consumer Thread");

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        System.out.println(" Completed !");
    }
}
