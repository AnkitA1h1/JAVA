package multithreading;

public class PriorityExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println(""+Thread.currentThread().getName()+ " - "+i);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println(""+Thread.currentThread().getName()+ " - "+i);
            }
        });

        t1.setName("High");
        t2.setName("Low");

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}
