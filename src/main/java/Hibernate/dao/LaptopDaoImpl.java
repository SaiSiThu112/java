package Hibernate.dao;

import Hibernate.entity.Laptop;
import Hibernate.repository.LaptopRepository;

import java.util.List;

public class LaptopDaoImpl extends AbstractDaoImpl<Laptop , Long> implements LaptopRepository {

    public LaptopDaoImpl(){
        super();
    }

    @Override
    public Laptop findOne(Long id) {
        return super.findOne(id);
    }

    @Override
    public Laptop save(Laptop entity) {
        return super.save(entity);
    }

    @Override
    public List<Laptop> findAll() {
        return super.findAll();
    }

    @Override
    public Laptop update(Laptop entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Laptop entity) {
        super.delete(entity);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
}
