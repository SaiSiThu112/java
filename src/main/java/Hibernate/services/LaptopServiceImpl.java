package Hibernate.services;

import Hibernate.dto.LaptopDto;
import Hibernate.entity.Laptop;
import Hibernate.repository.LaptopRepository;

import java.util.ArrayList;
import java.util.List;

public class LaptopServiceImpl implements LaptopService{

    private LaptopRepository repo;

    public LaptopServiceImpl(LaptopRepository repo) {
        this.repo = repo;
    }

    @Override
    public LaptopDto findOne(Long id) {
        Laptop laptop = repo.findOne(id);
        LaptopDto dto = new LaptopDto(laptop);
        return dto;
    }

    @Override
    public LaptopDto save(LaptopDto entity) {
        Laptop laptop = repo.save(entity.getEntity());
        return new LaptopDto(laptop);
    }

    @Override
    public LaptopDto update(LaptopDto entity) {
        Laptop laptop = repo.update(entity.getEntity());
        return new LaptopDto(laptop);
    }

    @Override
    public void delete(LaptopDto entity) {
         repo.delete(entity.getEntity());
    }

    @Override
    public void deleteByID(Long id) {
        repo.deleteByID(id);
    }

    @Override
    public List<LaptopDto> findAll() {
        List<Laptop> laptops = repo.findAll();
        List<LaptopDto> lapDtoList = null;
        for(Laptop laptop:laptops){
            if(lapDtoList==null){
                lapDtoList = new ArrayList<>();
            }
            LaptopDto dto = new LaptopDto(laptop);
            lapDtoList.add(dto);
        }
        return lapDtoList;
    }
}
