package Hibernate.dto;

import Hibernate.entity.BaseEntity;
import Hibernate.entity.Laptop;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaptopDto extends BaseEntity<Long> {

    private String brand , description ;

    public LaptopDto(Laptop lap){
        super.setId(lap.getId());
        this.brand= lap.getBrand();
        this.description= lap.getDescription();
    }

    public Laptop getEntity(){
        Laptop laptop = new Laptop();
        laptop.setBrand(this.brand);
        laptop.setDescription(this.description);
        return laptop;
    }
}
