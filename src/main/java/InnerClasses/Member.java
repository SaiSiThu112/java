package InnerClasses;

class Outer{
    private int value=20;

    class Inner{
        void show(){
            System.out.println("Value is "+value+".");
        }

    }
    public void display(){
        Inner obj=new Inner();
        obj.show();
    }
}

public class Member {
    public static void main(String[] args) {
            Outer outer=new Outer();
           //outer.display();
            Outer.Inner inner = outer.new Inner();
            inner.show();//set private to inner class then gg!
    }
}
