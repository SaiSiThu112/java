package multithreading;

class Processor{

    public void Producer() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer is working");
            wait();
            System.out.println("Producer is resume");
        }

    }
    public void Consumer() throws InterruptedException{
        Thread.sleep(2000);
        synchronized (this){
            System.out.println("Consumer is working");
            notify();
        }
    }
}

public class demo {
    public static void main(String[] args) {

        Processor processor = new Processor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.Producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.Consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
