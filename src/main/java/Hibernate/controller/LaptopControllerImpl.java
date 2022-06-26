package Hibernate.controller;

import Hibernate.dto.LaptopDto;
import Hibernate.entity.Laptop;
import Hibernate.services.LaptopService;
import Hibernate.view.LaptopView;

import java.util.ArrayList;
import java.util.List;

public class LaptopControllerImpl extends AbstractControllerImpl<Laptop, LaptopView > implements LaptopController<Laptop>{

    private LaptopService service;

    public LaptopControllerImpl(LaptopService service) {
        this.service = service;
    }

    @Override
    public Laptop findById(Long id) {
        LaptopDto dto = service.findOne(id);
        return dto.getEntity();
    }

    @Override
    public List<Laptop> findAll() {
        List<LaptopDto> dtoList = service.findAll();
        List<Laptop> laptops = null;
        for(LaptopDto  dto: dtoList){
            if(laptops==null){
                laptops = new ArrayList<>();
            }
            laptops.add(dto.getEntity());
        }
        return laptops;
    }

    @Override
    public Laptop save(Laptop model) {
        LaptopDto dto = service.save(new LaptopDto(model));
        return dto.getEntity();
    }

    @Override
    public Laptop update(Laptop model) {
        LaptopDto dto = service.update(new LaptopDto(model));
        return dto.getEntity();
    }

    @Override
    public void delete(Laptop model) {
        service.delete(new LaptopDto(model));
    }

    @Override
    public void deleteById(Long id) {
        service.deleteByID(id);
    }

    @Override
    public void printDetails(Laptop laptop) {
        super.printDetails(laptop);
    }

    @Override
    public void printDetails(List<Laptop> laptops) {
        super.printDetails(laptops);
    }

    @Override
    public Laptop getModel() {
        return super.getModel();
    }

    @Override
    public void setModel(Laptop laptop) {
        super.setModel(laptop);
    }

    @Override
    public LaptopView getView() {
        return super.getView();
    }

    @Override
    public void setView(LaptopView view) {
        super.setView(view);
    }
}
