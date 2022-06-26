package oop;

interface LivingCreature{
    void printName();
}

class Person implements LivingCreature{

    @Override
    public void printName() {
        System.out.println("I am human!");
    }
}

class Dog implements LivingCreature{

    @Override
    public void printName() {
        System.out.println("I am dog wolf wolf!");
    }
}

class ShowLivingCreatureName<T extends LivingCreature>  {

    public T getData(T data){
        return data;
    }
}

public class App {
    public static void main(String[] args) {
        Person prn = new Person();
        Dog dog = new Dog();

        ShowLivingCreatureName<Person> obj1 = new ShowLivingCreatureName<>();
        obj1.getData(prn).printName();

        ShowLivingCreatureName<Dog> obj2 = new ShowLivingCreatureName<>();
        obj2.getData(dog).printName();
    }
}
