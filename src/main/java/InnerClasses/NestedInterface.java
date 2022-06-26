package InnerClasses;

interface Showable{
         interface message{
            void msg();
        }
        interface Alert{
             void alert();
        }

}

public class NestedInterface implements Showable.Alert{
    public static void main(String[] args) {
            NestedInterface obj=new NestedInterface();
            obj.alert();
    }

    @Override
    public void alert() {
        System.out.println("Warning!");
    }
}