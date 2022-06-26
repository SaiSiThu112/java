package designPatternTest.behaviourDP;

enum Color{
    Red,Black,White
}

interface Light{
    void on();
    void off();
}

interface Button{
    void press();
}
class Bulb implements Light{

    @Override
    public void on() {
        System.out.println("Bulb Light is on");
    }

    @Override
    public void off() {
        System.out.println("Bulb Light is off");
    }
}

class LightSwitchOn implements Button{

    Light light;

    public LightSwitchOn(Light light){
        this.light=light;
    }

    @Override
    public void press() {
        light.on();
    }
}

class LightForStudy implements Button{

    Light light;

    public LightForStudy(Light light){
        this.light=light;
    }

    public void white(){
        System.out.println(Color.White + " light on");
    }

    @Override
    public void press() {
        light.on();
        white();
    }
}
public class CommandDemo {
    public static void main(String[] args) {
        Bulb bulb = new Bulb();
        Button btn = new LightForStudy(bulb);
        btn.press();

    }
}
