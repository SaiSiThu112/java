package Hibernate.services;

import Hibernate.dto.PersonDto;
import Hibernate.entity.Person;
import Hibernate.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService{

    private  PersonRepository repo ;

    public PersonServiceImpl(PersonRepository repo){
        this.repo = repo;
    }

    @Override
    public PersonDto findOne(Long id) {
        Person person = repo.findOne(id);
        PersonDto dto = new PersonDto(person);
        return dto;
    }

    @Override
    public PersonDto save(PersonDto entity) {
        Person person = repo.save(entity.getEntity());
        return new PersonDto(person);
    }

    @Override
    public PersonDto update(PersonDto entity) {
        Person person = repo.update(entity.getEntity());
        return new PersonDto(person);
    }

    @Override
    public void delete(PersonDto entity) {
        repo.delete(entity.getEntity());
    }

    @Override
    public void deleteByID(Long id) {
        repo.deleteByID(id);
    }

    @Override
    public List<PersonDto> findAll() {
        List<Person> people = repo.findAll();
        List<PersonDto> personListDto = null;
        for(Person person : people){
            if(personListDto==null){
                personListDto = new ArrayList<>();
            }
            PersonDto dto = new PersonDto(person);
            personListDto.add(dto);
        }
        return personListDto;
    }

}
