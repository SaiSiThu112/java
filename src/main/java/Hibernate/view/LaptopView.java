package Hibernate.view;

import Hibernate.entity.Laptop;

import java.util.List;

public class LaptopView extends AbstractViewImpl<Laptop >{

    @Override
    public void printDetails(Laptop model) {

        StringBuilder sb = new StringBuilder();
        sb.append("laptop id =");
        sb.append(model.getId());
        sb.append(" , brand");
        sb.append(model.getBrand());
        sb.append(" , description");
        sb.append(model.getDescription());
        System.out.println(sb.toString());
    }

}
