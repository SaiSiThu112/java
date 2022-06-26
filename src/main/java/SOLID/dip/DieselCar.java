package SOLID.dip;

public class DieselCar implements Vehicle {

   private Wheel wheel=new Wheel();
   private Gasoline gas=new DieselOil();

   /*public DieselCar(){
       this.wheel= new Wheel();
       this.gas=new DieselOil();
   }

   public DieselCar(Wheel wheel,Gasoline gas){
    this.wheel=wheel;
    this.gas=gas;
   }*/

    @Override
    public void drive() {
        if(gas.isEmpty()|| !gas.isDiesel()){
            System.out.println("Car cannot drive!");
            return;
        }
        this.wheel.rollForwards();
    }

    @Override
    public void moveBackwards() {
        this.wheel.rollBackwards();
    }
}
