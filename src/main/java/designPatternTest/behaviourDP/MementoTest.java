package designPatternTest.behaviourDP;

import java.util.ArrayList;
import java.util.List;

class PhMessage{
    String message;

    public PhMessage(String message){
        this.message = message;

    }

    public String toString() {
        return " PhMessage{ " +
                "message = " + message +
                " }";
    }

    public String getMessage(){
        return this.message;
    }
}

class MessageApp{

    String message;

    public void setMessage(String message){
        System.out.println("Setting phone message "+ message);
        this.message = message;
    }
    public PhMessage saveToMemory(){
        System.out.println("Phone message : Saving to memory ");
        return new PhMessage(this.message);
    }
    public void restoreMessageHistory(PhMessage message){
        this.message= message.message;
        System.out.println("Message app history --> "+ message);
    }
}
public class MementoTest {
    public static void main(String[] args) {
        List<PhMessage> list = new ArrayList<>();
        MessageApp app = new MessageApp();
        app.setMessage("Message1");
        app.setMessage("Message2");
        app.setMessage("Message3");
        list.add(app.saveToMemory());
        app.restoreMessageHistory(list.get(0));
    }
}
