package designPatternTest.structuralDP;

interface Data{
    void show();
}
class PersonalData implements Data{

    @Override
    public void show() {
        System.out.println("Showing personal data");
    }
}
class DataProxy implements Data{

    boolean admin = false;

    public DataProxy(String password){

        if(password=="111"){
            admin = true;
        }
        else{
            System.out.println("Please try again >_<");
        }
    }

    @Override
    public void show() {
        if(admin){
            Data d = new PersonalData();
            d.show();
        }
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        Data d = new DataProxy("112");
        d.show();
    }
}
