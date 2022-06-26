package designPatternTest.creationalDP;

interface Laptop{
    void brandName();
}

class Acer implements Laptop{

    @Override
    public void brandName() {
        System.out.println("This laptop brand name is Acer");
    }
}

class Dell implements Laptop{

    @Override
    public void brandName() {
        System.out.println("This laptop brand name is Dell");
    }
}

abstract class LaptopFactory{

    abstract Laptop getLaptopFactory();
}

class AcerFactory extends LaptopFactory{

    @Override
    Laptop getLaptopFactory() {
        return new Acer();
    }
}

class DellFactory extends LaptopFactory{

    @Override
    Laptop getLaptopFactory() {
        return new Dell();
    }
}
public class factory {
    public static void main(String[] args) {

        Laptop laptop = new AcerFactory().getLaptopFactory();
        laptop.brandName();
    }
}
