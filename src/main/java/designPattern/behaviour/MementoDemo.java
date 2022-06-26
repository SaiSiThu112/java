package designPattern.behaviour;

import java.util.ArrayList;
import java.util.List;

class Memento{
    String state;

    public Memento(String state){
        this.state = state;
    }
    public String getState(){
        return state;
    }
}

class Originator{
    String state;

    public void setState(String state){
        System.out.println("Originator setting state "+state);
        this.state = state;
    }
    public Memento saveToMemento(){
        System.out.println("Originator: Saving to Memento");
        return new Memento(this.state);
    }
    public void restoreFromMemento(Memento memento){
        this.state = memento.state;
        System.out.println("Originator: State after restoring form Memento "+state);
    }
}

public class MementoDemo {
    public static void main(String[] args) {
        List<Memento> list = new ArrayList<>();
        Originator origin = new Originator();

        origin.setState("State1");
        origin.setState("State2");
        origin.setState("State3");
        list.add(origin.saveToMemento());

        origin.setState("State4");
        origin.restoreFromMemento(list.get(0));
        System.out.println("Origin state "+origin.state);
    }
}
