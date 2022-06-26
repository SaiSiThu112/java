package designPattern.structuralDP;

import java.util.ArrayList;
import java.util.List;

abstract class IntelliJ{

    String name;
    public IntelliJ(String name) {
        this.name=name;
    }

    abstract void open();
}

class Project extends IntelliJ{

    public Project(String name) {
        super(name);
    }

    @Override
    void open() {
        System.out.println(this.name + " is open");
    }
}

class Java extends IntelliJ{

    List<IntelliJ> folder = new ArrayList<>();

    public Java(String name) {
        super(name);
    }

    @Override
    void open() {
        System.out.println(this.name + " is open");
        for(IntelliJ pack : folder){
            pack.open();
        }
    }
    public void add(IntelliJ pack){
        this.folder.add(pack);
    }

}
public class Composition {
    public static void main(String[] args) {

       Java parent = new Java("Creational Design Pattern");
       Project p1 = new Project("Factory Design Pattern");
       Project p2 = new Project("Prototype Design Pattern");
       parent.add(p1);
       parent.add(p2);

       Java parent2 = new Java("Factory Design Pattern");
       Project p3 = new Project("Bridge Design Pattern");
       Project p4 = new Project("Adaptor Design Pattern");
       parent2.folder.add(p3);
       parent2.folder.add(p4);

       parent.add(parent2);
       parent.open();
    }
}
