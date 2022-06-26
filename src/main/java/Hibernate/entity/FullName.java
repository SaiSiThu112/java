package Hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FullName {

    @Column(name ="first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

}
