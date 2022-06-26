package designPatternTest.creationalDP;

interface Mage extends Cloneable{
    Mage magic();
}

class Mage2 implements Mage{

    String fire;
    String water;

    static String getFire(){
        return "Using fire magic";
    }
    static String getWater(){
        return "Using water magic";
    }

    public Mage2(){
        this.fire=getFire();
        this.water=getWater();
    }

    @Override
    public String toString() {
        return "Mage2{" + " fire = " + fire + ", water = " + water + "}";
    }

    @Override
    public Mage magic() {
        try {
            Mage mage = (Mage)super.clone();
            Mage2 another = (Mage2) mage ;
            return another;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
public class Prototype {
    public static void main(String[] args) {
        Mage2 chr = new Mage2();
        Mage2 chr1 = (Mage2) chr.magic();
        System.out.println(chr1);
    }
}
