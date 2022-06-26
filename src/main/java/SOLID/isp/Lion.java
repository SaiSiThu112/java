package SOLID.isp;

public class Lion extends AbstractLivingCreature implements LandCreature{

    @Override
    public void walk() {
        System.out.println("Walking!");
    }
}
