package SOLID.ocp;

import SOLID.SingleResponsibility.Color;
import SOLID.SingleResponsibility.Product;

public class ColorCondition implements Condition<Product> {

    private Color color;

    public ColorCondition(Color color){
        this.color=color;
    }

    @Override
    public boolean isMatched(Product item) {
        return item.getColor()==color;
    }
}
