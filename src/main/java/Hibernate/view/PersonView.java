package Hibernate.view;

import Hibernate.entity.Person;

public class PersonView extends AbstractViewImpl<Person>{

    @Override
    public void printDetails(Person model) {
        StringBuilder sb = new StringBuilder();
        sb.append("Person id=");
        sb.append(model.getId());
        sb.append(", name=");
        sb.append(model.getFullName().getFirstName());
        sb.append(", age=");
        sb.append(model.getAge());
        sb.append(", Laptop id=");
        try {
            sb.append(model.getLaptop().getId());
        }
        catch (NullPointerException e){
            sb.append("No laptop");
        }
        finally {
            System.out.println(sb.toString());
        }
    }
}
