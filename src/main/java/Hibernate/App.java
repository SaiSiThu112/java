package Hibernate;

import Hibernate.controller.LaptopController;
import Hibernate.controller.LaptopControllerImpl;
import Hibernate.controller.PersonController;
import Hibernate.controller.PersonControllerImpl;
import Hibernate.dao.LaptopDaoImpl;
import Hibernate.dao.PersonDaoImpl;
import Hibernate.entity.FullName;
import Hibernate.entity.Laptop;
import Hibernate.entity.Person;
import Hibernate.repository.LaptopRepository;
import Hibernate.repository.PersonRepository;
import Hibernate.services.LaptopService;
import Hibernate.services.LaptopServiceImpl;
import Hibernate.services.PersonServiceImpl;
import Hibernate.services.PersonService;

import java.util.List;

public class App {

    public static void main(String[] args) {
            Laptop laptop = new Laptop();
            laptop.setBrand("Acer");
            laptop.setDescription("This is  I5");

            Laptop laptop1 = new Laptop();
            laptop1.setBrand("Dell");
            laptop1.setDescription("Lu pyae");

            Person prn = new Person();
            prn.setFullName(new FullName("Sai ","Si Thu"));
            prn.setAge(22);
            prn.setLaptop(laptop);

            Person prn1 = new Person();
            prn1.setFullName(new FullName("Jay","Park"));
            prn1.setAge(37);
            prn1.setLaptop(laptop1);

            PersonRepository prnRepo = new PersonDaoImpl();
            PersonService prnService = new PersonServiceImpl(prnRepo);
            PersonController<Person>  prnController = new PersonControllerImpl(prnService);

            //prnController.save(prn);
            //prnController.save(prn1);

            List<Person> person = prnController.findAll();
            prnController.printDetails(person);
            prnController.delete(person.get(0));

            LaptopRepository lapRepo = new LaptopDaoImpl();
            LaptopService lapService = new LaptopServiceImpl(lapRepo);
            LaptopController<Laptop > lapController = new LaptopControllerImpl(lapService);

            lapController.save(laptop);

            Laptop out = lapController.findById(2L);

            PersonRepository prnRepo1 = new PersonDaoImpl();
            PersonService prnService1 = new PersonServiceImpl(prnRepo1);
            PersonController<Person>  prnController1 = new PersonControllerImpl(prnService1);

            prn.setLaptop(out);
            prnController1.save(prn);

            Person people = prnController.findById(1L);
            people.setAge(21);
            prnController.update(people);
            prnController.printDetails(people);

    }
}
