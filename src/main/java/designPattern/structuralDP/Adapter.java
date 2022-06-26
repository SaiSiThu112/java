package designPattern.structuralDP;

interface NewAPI{
    void add(Integer add);
}

class OldAPI{
    public void addItem(Integer item){
        System.out.println("OldAPI add item " + item );
    }
}

public class Adapter implements NewAPI{

    public static void main(String[] args) {
        NewAPI api = new Adapter();
        api.add(30);
    }

    OldAPI oldAPI = new OldAPI();
    @Override
    public void add(Integer item) {
        oldAPI.addItem(item);
    }
}
