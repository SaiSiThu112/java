package InnerClasses;

class Outer1{
    private static int value=20;

    static class Inner1{
         public void print(){
            System.out.println("Value is "+value+".");
        }
    }
}
public class StaticNestedInterface {
    public static void main(String[] args) {
            Outer1 outer=new Outer1();
            Outer1.Inner1 inner=new Outer1.Inner1();
            inner.print();
    }
}
