package SOLID.SingleResponsibility;

import SOLID.ocp.Condition;
import SOLID.ocp.Filter;

import java.util.List;

public class ProductFilter implements Filter<Product> {

    @Override
    public void filter(List<Product> items, Condition<Product> condition) {
    for(Product out:items){
        if(condition.isMatched(out)){
            System.out.println(out.getName());
        }
    }
    }
}
