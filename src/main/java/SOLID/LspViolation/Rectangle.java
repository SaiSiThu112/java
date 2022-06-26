package SOLID.LspViolation;

public class Rectangle implements IRectangle{

   private double width, length;

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public void setWidth(double width) {
    this.width=width;
    }

    @Override
    public void setLength(double length) {
    this.length=length;
    }

    @Override
    public double getArea() {
        return width*length;
    }
}
