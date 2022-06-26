package Hibernate.controller;

import Hibernate.entity.Person;
import Hibernate.view.AbstractView;

import java.util.List;

public interface PersonController<T extends Person > extends AbstractView<T> {

    T findById(Long id);
    List<T> findAll();

    T save(T model);
    T update(T model);
    void delete(T model);
    void deleteById(Long id);
}
