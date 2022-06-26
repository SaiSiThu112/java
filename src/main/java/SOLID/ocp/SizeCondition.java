package SOLID.ocp;

import SOLID.SingleResponsibility.Product;
import SOLID.SingleResponsibility.Size;

public class SizeCondition implements Condition<Product> {

    private Size size;

    public SizeCondition(Size size){
        this.size=size;
    }

    @Override
    public boolean isMatched(Product item) {
        return item.getSize()==size;
    }
}
