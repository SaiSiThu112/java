package SOLID.dip;

public class OctaneOil implements Gasoline{
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isDiesel() {
        return false;
    }
}
