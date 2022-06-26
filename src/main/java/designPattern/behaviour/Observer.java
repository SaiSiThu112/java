package designPattern.behaviour;

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
    String viewName;

    public View(String viewName){
        this.viewName=viewName;
    }

    @Override
    public void update(String message) {
        System.out.println("View "+viewName+" update to "+message);
    }
}

class DataSource implements Publisher{

    List<Subscriber> subscriberList = new ArrayList<>();

    @Override
    public void attach(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void change(String message) {
        System.out.println("Publisher change "+message);
        for(Subscriber sub : subscriberList){
            sub.update(message);
        }
    }
}

public class Observer {
    public static void main(String[] args) {
        Publisher datasource = new DataSource();
        View v1 = new View("View 1");
        View v2 = new View("View 2");
        View v3 = new View("view 3");
        datasource.attach(v1);
        datasource.attach(v2);
        datasource.attach(v3);
        datasource.change("Change 1");
        datasource.change("Change 2");

    }
}
