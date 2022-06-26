package Hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name ="person")
@Getter
@Setter
public class Person extends BaseEntity<Long>{

     @Embedded
     private FullName fullName;

     @Column(length = 3)
     private int age;

     @OneToOne(cascade = CascadeType.ALL) // one delete cascade
     @JoinColumn(name ="laptop_id")
     private Laptop laptop;

}
