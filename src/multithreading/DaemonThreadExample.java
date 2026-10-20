package multithreading;

public class DaemonThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while(true){
                System.out.println("Daemon Thread");
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }

        });
        t.setDaemon(true);

        t.start();

        Thread.sleep(1200);
        System.out.println("main thread finish");

    }
}
