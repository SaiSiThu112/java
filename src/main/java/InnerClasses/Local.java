package InnerClasses;

class Out{
    private int value=50;

    public void display(){
        class LocalIn{
            void show(){
                System.out.println("Value is "+value+".");
            }
        }

        LocalIn obj=new LocalIn();
        obj.show();
    }
}
public class Local {
    public static void main(String[] args) {
        Out obj=new Out();
        obj.display();
    }
}
