package designPatternTest.structuralDP;

interface ShooterGame{
    void solo();
    void party();
}

class CSG implements ShooterGame{

    @Override
    public void solo() {
        System.out.println("play CSG solo");
    }

    @Override
    public void party() {
        System.out.println("play CSG with full party");
    }
}

class Valorant implements ShooterGame{

    @Override
    public void solo() {
        System.out.println("play Valorant solo");
    }

    @Override
    public void party() {
        System.out.println("play Valorant with full party");
    }
}

abstract class Mode{
    ShooterGame shooterGame;

    public Mode(ShooterGame shooterGame){
        this.shooterGame=shooterGame;
    }
    abstract void play();
}

class Competitive extends Mode{

    public Competitive(ShooterGame shooterGame){
        super(shooterGame);
    }

    @Override
    void play() {
        shooterGame.solo();
    }
}

class Chill extends Mode{

    public Chill(ShooterGame shooterGame) {
        super(shooterGame);
    }

    @Override
    void play() {
        shooterGame.party();
    }
}
public class BridgeTest {
    public static void main(String[] args) {
        ShooterGame game = new CSG();
        Mode mode = new Competitive(game);
        mode.play();
    }
}
