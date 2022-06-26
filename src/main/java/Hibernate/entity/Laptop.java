package Hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="laptop")
@Getter
@Setter
public class Laptop extends BaseEntity<Long> {

    @Column(name = "brand" , length = 20)
    private String brand;

    @Column(name = "description" , length = 500)
    private String description;

}
