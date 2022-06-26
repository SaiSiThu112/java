package Hibernate.dao;

import Hibernate.entity.Person;
import Hibernate.repository.PersonRepository;

import java.util.List;

public class PersonDaoImpl extends AbstractDaoImpl<Person , Long> implements PersonRepository {

    public PersonDaoImpl() {
        super();
    }

    @Override
    public Person findOne(Long id) {
        return super.findOne(id);
    }

    @Override
    public Person save(Person entity) {
        return super.save(entity);
    }

    @Override
    public List<Person> findAll() {
        return super.findAll();
    }

    @Override
    public Person update(Person entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Person entity) {
        super.delete(entity);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
}
