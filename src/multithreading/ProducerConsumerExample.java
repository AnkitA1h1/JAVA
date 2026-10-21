package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        Thread producer = new Thread(()->{
            try{
                for(int i=0;i<5;i++){
                    queue.put(i);
                    System.out.println("producer - " + i);
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(()->{
            try{
                for(int i=0;i<5;i++){
                    int val = queue.take();
                    System.out.println("consumer - " + val);
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
