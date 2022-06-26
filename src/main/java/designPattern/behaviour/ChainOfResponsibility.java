package designPattern.behaviour;

class Command{
    int amount;
    public Command(int amount){
        this.amount=amount;
    }
}

abstract class PurchasePower{

    static final int BASE = 10;
    PurchasePower purchasePower;

    public void setPurchasePower(PurchasePower purchasePower){
        this.purchasePower= purchasePower;
    }
    public PurchasePower getPurchasePower(){
        return purchasePower;
    }
    abstract void handleRequest(Command command);
}

class ManagerPower extends PurchasePower{
    static final int ALLOW = BASE * 10;

    @Override
    void handleRequest(Command command) {
        if (command.amount <= ALLOW){
            System.out.println("Sale handle by Manager");
        }
        else {
            if(this.getPurchasePower()!=null){
                purchasePower.handleRequest(command);
            }
        }
    }
}

class DirectorPower extends PurchasePower{
    static final int ALLOW = BASE * 20;

    @Override
    void handleRequest(Command command) {
        if(command.amount<=ALLOW){
            System.out.println("Sale handle by Director");
        }
        else{
            if(this.getPurchasePower()!=null){
                purchasePower.handleRequest(command);
            }
        }
    }
}
class VoicePresidentPower extends PurchasePower{
    static final int ALLOW = BASE *30;

    @Override
    void handleRequest(Command command) {
        if (command.amount<=ALLOW){
            System.out.println("Sale handle by Voice President");
        }
        else{
            if(this.getPurchasePower()!=null){
                purchasePower.handleRequest(command);
            }
        }
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        ManagerPower mp = new ManagerPower();
        DirectorPower dp = new DirectorPower();
        VoicePresidentPower vp = new VoicePresidentPower();
        mp.setPurchasePower(dp);
        dp.setPurchasePower(vp);

        Command command = new Command(10);
        mp.handleRequest(new Command(1020));
        mp.handleRequest(new Command(200));
        mp.handleRequest(new Command(600));
        mp.handleRequest(new Command(100));
    }
}
