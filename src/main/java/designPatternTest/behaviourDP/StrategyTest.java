package designPatternTest.behaviourDP;

interface Decision{
    void decide();
}

class DecisionContext{
    Decision decision ;

    public void pick(){
        this.decision.decide();
    }
    public void setDecision(Decision decision){
        this.decision = decision;
    }
    public Decision getDecision(){
        return decision;
    }
}

class Carry implements Decision{

    @Override
    public void decide() {
        System.out.println("Pick carry");
    }
}

class Support implements Decision{

    @Override
    public void decide() {
        System.out.println("Pick support");
    }
}

public class StrategyTest{
    public static void main(String[] args) {
        DecisionContext context = new DecisionContext();
        context.setDecision(new Carry());
        context.pick();

        context.setDecision(new Support());
        context.pick();
    }
}
