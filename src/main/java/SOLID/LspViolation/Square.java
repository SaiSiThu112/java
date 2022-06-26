package SOLID.LspViolation;

public class Square implements ISquare{

    private double side;

    @Override
    public double getSide() {
        return side;
    }

    @Override
    public void setSide(double side) {
    this.side=side;
    }

    @Override
    public double getArea() {
        return side*side;
    }

}
