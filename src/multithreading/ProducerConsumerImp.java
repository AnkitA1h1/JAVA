package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerImp {

    static class SharedBuffer{
        private final Queue<Integer> queue = new LinkedList<>();

        private int capacity;

        public SharedBuffer(int capacity){
            if(capacity < 0){
                throw new IllegalArgumentException("value should be positive!");
            }
            this.capacity = capacity;
        }


        public synchronized void producer(int value){
            while (queue.size() == capacity){
                try{
                    System.out.println("Buffer Full - Producer is waiting");
                    wait();
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            queue.add(value);

            System.out.println("Producer - "+ value+ "| Buffer: "+queue);

            notifyAll();
        }

        public synchronized void consumer(){
            while(queue.isEmpty()){
                try {
                    System.out.println("Buffer is Empty -- Consumer is waiting");
                    wait();
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            System.out.println("Consumer - "+queue.remove() + "| Buffer: "+queue);

            notifyAll();
        }
    }



    public static void main(String[] args) throws InterruptedException {

        SharedBuffer sharedBuffer = new SharedBuffer(3);

        Thread producer = new Thread(()->{
            for(int i=1;i<=10;i++){
                sharedBuffer.producer(i);
            }
        });

        Thread consumer = new Thread(()->{
            for(int i=1;i<=10;i++){
                sharedBuffer.consumer();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("process completed");
    }
}
