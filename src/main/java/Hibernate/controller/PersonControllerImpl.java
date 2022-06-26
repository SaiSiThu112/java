package Hibernate.controller;

import Hibernate.dto.PersonDto;
import Hibernate.entity.Person;
import Hibernate.services.PersonService;
import Hibernate.view.PersonView;

import java.util.ArrayList;
import java.util.List;

public class PersonControllerImpl extends AbstractControllerImpl<Person, PersonView> implements PersonController<Person>{

    private PersonService service;

    public PersonControllerImpl(PersonService service){
        this.service= service;
    }

    @Override
    public Person findById(Long id) {
        PersonDto dto = service.findOne(id);
        return dto.getEntity();
    }

    @Override
    public List<Person> findAll() {
        List<PersonDto> dtoList = service.findAll();
        List<Person> people = null;
        for(PersonDto dto : dtoList){
            if(people==null){
                people = new ArrayList<>();
            }
            people.add(dto.getEntity());
        }
        return people;
    }

    @Override
    public Person save(Person model) {
        PersonDto dto =service.save(new PersonDto(model));
        return dto.getEntity();
    }

    @Override
    public Person update(Person model) {
        PersonDto dto = service.update(new PersonDto(model));
        return dto.getEntity();
    }

    @Override
    public void delete(Person model) {
        service.delete(new PersonDto(model));
    }

    @Override
    public void deleteById(Long id) {
        service.deleteByID(id);
    }

    @Override
    public void printDetails(Person person) {
        super.printDetails(person);
    }

    @Override
    public void printDetails(List<Person> people) {
        super.printDetails(people);
    }

    @Override
    public Person getModel() {
        return super.getModel();
    }

    @Override
    public void setModel(Person person) {
        super.setModel(person);
    }

    @Override
    public PersonView getView() {
        return super.getView();
    }

    @Override
    public void setView(PersonView view) {
        super.setView(view);
    }
}
