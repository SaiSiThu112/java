package SOLID.run;

import SOLID.dip.*;
import SOLID.isp.Egret;
import SOLID.isp.Lion;
import SOLID.LspViolation.*;
import SOLID.SingleResponsibility.Color;
import SOLID.SingleResponsibility.Product;
import SOLID.SingleResponsibility.ProductFilter;
import SOLID.SingleResponsibility.Size;
import SOLID.ocp.AndCondition;
import SOLID.ocp.ColorCondition;
import SOLID.ocp.SizeCondition;

import java.util.List;

public class App {
    public static void main(String[] args) {
            App obj = new App();
            //obj.OCP();
            //obj.LspViolation();
            obj.LSP();
            //obj.ISP();
            //obj.DIP();
    }

    public List<Product> getAllProducts(){
        Product police = new Product("Police",1000,Size.M,Color.WHITE);
        Product jacket = new Product("LV Jacket",2000,Size.M,Color.WHITE);
        Product underWare = new Product("UnderWare",6000,Size.S,Color.BLACK);
        Product tShirt = new Product("t-Shirt",8000,Size.XXL,Color.RED);

        return List.of(police,jacket,underWare,tShirt);
    }

    public void OCP(){
        ProductFilter pf= new ProductFilter();
        //pf.filter(obj.getAllProducts(),new ColorCondition(Color.WHITE));
        //pf.filter(obj.getAllProducts(),new SizeCondition(Size.S));
        pf.filter(getAllProducts(), new AndCondition<Product>(new ColorCondition(Color.WHITE),new SizeCondition(Size.M)));
    }

    public void LspViolation(){
        Bird bird = new Bird();
        bird.fly();

        Aeroplane aero= new Aeroplane();
        aero.fly();
    }

    public void LSP(){
        Rectangle ret =new Rectangle();
        ret.setWidth(5);
        ret.setLength(2);
        System.out.println(ret.getArea());

        Square squ=new Square();
        squ.setSide(4);
        System.out.println(squ.getArea());

        /*List<Shape> list =new ArrayList<>();
        list.add(ret);
        list.add(squ);
        for(Shape out:list){
            System.out.println(out.getArea());
        }*/

    }
    public void ISP() {
        Lion lion =new Lion();
        lion.eat();
        lion.sleep();
        lion.sex();
        lion.walk();

        Egret egret =new Egret();
        egret.fly();
        egret.eat();
        egret.walk();
        egret.swim();
    }

    public void DIP(){
        Wheel wheel= new Wheel();
        Gasoline diesel=new DieselOil();
        Gasoline octane=new OctaneOil();

        Vehicle car= new DieselCar();
        car.drive();

    }
}
