package testing;

import java.util.ArrayList;
import java.util.List;

abstract class GeneratedSourceRoot{
    String name;
    public GeneratedSourceRoot(String name){
        this.name = name;
    }
    abstract void create();
}

class ClassDemo extends GeneratedSourceRoot{

    public ClassDemo(String name) {
        super(name);
    }

    @Override
    void create() {
        System.out.println(this.name+" is created.");
    }
}

class Package extends GeneratedSourceRoot{

    List<GeneratedSourceRoot>classFiles = new ArrayList<>();


    public Package(String name) {
        super(name);
    }

    @Override
    void create() {
        System.out.println(this.name+" is created.");
        for(GeneratedSourceRoot file : classFiles){
            file.create();
        }
    }
}

public class testOne {
    public static void main(String[] args) {
        Package pack = new Package("designPattern Package");
        ClassDemo classDemo = new ClassDemo("FactoryDemo.java");
        ClassDemo classDemo1 = new ClassDemo("BuilderDemo.java");
        pack.classFiles.add(classDemo);
        pack.classFiles.add(classDemo1);

        Package pack2 = new Package("StructuralDesign Package");
        ClassDemo classDemo3 = new ClassDemo("Adapter.java");
        ClassDemo classDemo4 = new ClassDemo("Composite.java");
        pack2.classFiles.add(classDemo3);
        pack2.classFiles.add(classDemo4);

        pack.classFiles.add(pack2);
        pack.create();

    }
}
