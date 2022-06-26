package SOLID.isp;

public class Egret extends AbstractLivingCreature implements LandCreature,FlyingCreature,AquaticCreature {

    @Override
    public void fly() {
        System.out.println("Flying!");
    }

    @Override
    public void walk() {
        System.out.println("Walking!");
    }

    @Override
    public void swim() {
        System.out.println("Swim!");
    }
}
