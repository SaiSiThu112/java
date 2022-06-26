package Hibernate.controller;

import Hibernate.entity.Laptop;
import Hibernate.view.AbstractView;
import com.sun.xml.bind.v2.model.core.ID;

import java.util.List;

public interface LaptopController<T extends Laptop > extends AbstractView<T> {

    T findById(Long id);
    List<T> findAll();

    T save(T model);
    T update(T model);
    void delete(T model);
    void deleteById(Long id);
}
