package designPattern.behaviour;

interface State{
    void doAction(StateContext context);
}

class StateContext{
    State currentState;

    public StateContext(State initial){
        this.currentState=initial;

    }
    public void changeState(State newState){
        this.currentState=newState;
    }
    public void doAction(){
        this.currentState.doAction(this);
    }
}

class FullState implements State{

    @Override
    public void doAction(StateContext context) {
        System.out.println("I am full");

    }
}

class HungryState implements State{

    @Override
    public void doAction(StateContext context) {
        System.out.println("I am hungry");
        context.changeState(new EatingState());
    }
}

class EatingState implements State{

    @Override
    public void doAction(StateContext context) {
        System.out.println("I am eating");
        context.changeState(new FullState());
    }
}

public class StateDemo {
    public static void main(String[] args) {
        StateContext context = new StateContext(new HungryState());
        context.doAction();
        context.doAction();
        context.doAction();
    }
}
