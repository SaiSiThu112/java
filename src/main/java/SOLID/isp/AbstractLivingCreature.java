package SOLID.isp;

public class AbstractLivingCreature implements LivingCreature{
    @Override
    public void eat() {
        System.out.println("Eat!");
    }

    @Override
    public void sleep() {
        System.out.println("Sleep!");
    }

    @Override
    public void sex() {
        System.out.println("Sex!");
    }
}
