package SOLID.SingleResponsibility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product {
    private String name;
    private Color color;
    private Size size;
    private double price;

    public Product(String name, double price, Size size, Color color) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
    }
}
