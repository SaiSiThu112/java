package multithreading;

class  Singleton{
    private static Singleton object;

    private Singleton() {
        System.out.println("Object is created!");
    }

    public synchronized static Singleton getObject(){
        if(object==null){
            object = new Singleton();
        }
        return object;
    }
}

class MultiThreadingTest implements Runnable{
    @Override
    public void run() {
        try{
            System.out.println("create");
            Singleton.getObject();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

public class singleMulti extends Thread{
    public static void main(String[] args) {
        Thread obj1 = new Thread(new MultiThreadingTest());
        Thread obj2 = new Thread(new MultiThreadingTest());
        Thread obj3 = new Thread(new MultiThreadingTest());
        Thread obj4 = new Thread(new MultiThreadingTest());
        Thread obj5 = new Thread(new MultiThreadingTest());
        Thread obj6 = new Thread(new MultiThreadingTest());

        obj1.start();
        obj2.start();
        obj3.start();
        obj4.start();
        obj5.start();
        obj6.start();
    }
}
