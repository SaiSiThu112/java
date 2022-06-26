package SOLID.ocp;

public class AndCondition<T> implements Condition<T> {

   private Condition<T> one,two;

   public AndCondition(Condition<T> one ,Condition<T> two){
       this.one=one;
       this.two=two;
    }

    @Override
    public boolean isMatched(T item) {
        return one.isMatched(item)&&two.isMatched(item);
    }
}
