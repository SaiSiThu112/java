package testing;

enum Color{
    Pink,Red,Blue,RGB,PaleBlue;
}
interface Button{
    void press();
}

interface Light{
    void on();
    void off();
}

class Bulb implements Light{
    @Override
    public void on(){
        System.out.println("Bulb is on");
    }
    @Override
    public void off(){
        System.out.println("Bulb is off");
    }
}

class SwitchSenserOn implements Button{

    Light light;

    public SwitchSenserOn(Light light){
        this.light = light;
    }

    @Override
    public void press() {
        light.on();
    }
}

class SwitchSenserCustomLightOn implements Button{

    Light light;

    public SwitchSenserCustomLightOn(Light light){
        this.light = light;
    }

    public void rgb(){
        System.out.println("Lighting "+Color.RGB);
    }

    @Override
    public void press() {
        light.on();
        rgb();
    }
}

class SwitchSenserOff implements Button{

    Light light;

    public SwitchSenserOff(Light light){
        this.light = light;
    }

    @Override
    public void press() {
        light.off();
    }
}

public class testThree {
    public static void main(String[] args) {
        Light bulb = new Bulb();
        Button button = new SwitchSenserCustomLightOn(bulb);
        button.press();
    }
}
