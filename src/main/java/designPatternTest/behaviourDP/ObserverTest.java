package designPatternTest.behaviourDP;

import java.util.ArrayList;
import java.util.List;

interface Publisher{
    void attach(Subscriber subscriber);
    void change(String message);
}

interface Subscriber{
    void update(String message);
}

class View implements Subscriber{

    String name;

    public View(String name){
        this.name=name;
    }

    @Override
    public void update(String message) {
        System.out.println(" View "+name+" update to "+message);
    }
}

class DataSource implements Publisher{

    List<Subscriber> list = new ArrayList<>();

    @Override
    public void attach(Subscriber subscriber) {
        list.add(subscriber);
    }

    @Override
    public void change(String message) {
        System.out.println(" Publisher change "+message);
        for(Subscriber sub : list){
            sub.update(message);
        }
    }
}
public class ObserverTest {
    public static void main(String[] args) {
        Publisher ds = new DataSource();
        View v1 = new View("One");
        View v2 = new View("Two");
        View v3 = new View("Three");
        ds.attach(v1);
        ds.attach(v2);
        ds.attach(v3);
        ds.change("Change 1");
        ds.change("Change 2");
    }
}
