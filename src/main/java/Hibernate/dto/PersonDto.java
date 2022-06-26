package Hibernate.dto;

import Hibernate.entity.BaseEntity;
import Hibernate.entity.FullName;
import Hibernate.entity.Laptop;
import Hibernate.entity.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto extends BaseEntity<Long> {

    private String firstName,lastName;
    private int age;
    private Laptop laptop;

    public PersonDto (Person prn){
        super.setId(prn.getId());
        this.firstName = prn.getFullName().getFirstName();
        this.lastName = prn.getFullName().getLastName();
        this.age = prn.getAge();
        this.laptop = prn.getLaptop();
    }

    public Person getEntity(){
        Person person = new Person();
        person.setFullName(new FullName(this.firstName ,this.lastName));
        person.setId(this.getId());
        person.setLaptop(this.laptop);
        person.setAge(this.age);
        return person;
    }
}
