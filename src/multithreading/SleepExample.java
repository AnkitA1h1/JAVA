package multithreading;

public class SleepExample {
    public static void main(String[] args) {
        Thread t = new Thread(() ->{
            for(int i=1;i<=5;i++){
                System.out.println(i);

                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){

                }
            }
        });

        t.start();
    }
}
