package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Print3ThreadSequence {
    private int number = 1;
    private final int MAX = 100;
    public static void main(String[] args) throws InterruptedException {

        Print3ThreadSequence obj = new Print3ThreadSequence();

        Thread t1 = new Thread(() -> obj.printNumber(0));
        Thread t2 = new Thread(() -> obj.printNumber(1));
        Thread t3 = new Thread(() -> obj.printNumber(2));



        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }


    public synchronized void printNumber(int threadId){ // only one thread can enter

        while(number <= MAX){

            while(number <= MAX && (number-1)%3 != threadId){
                try{
                    wait(); // release monitor lock and got to Waiting state so, another thread can enter in method printNumber
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    notifyAll();
                    return;
                }
            }

            if(number > MAX){
                notifyAll();
                return;
            }

            System.out.println("Thread "+threadId+ "- "+number++);

            notifyAll(); // all waiting thread will be in Running state to acquire the monitor lock
        }
    }
}
