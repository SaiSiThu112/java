package testing;

import java.util.ArrayList;
import java.util.List;

public class testFour {
    public static void main(String[] args) {
        MultiPlayerMediator mediator = new MediatorImpl();
        Player player1 = new GamePlayer(mediator,"Player1");
        Player player2 = new GamePlayer(mediator,"Player2");
        Player player3 = new GamePlayer(mediator,"Player3");
        player1.sendMovement("Player1 melee attack.");
        player2.sendMovement("Player2 fire ball");
        player3.sendMovement("Player3 shield def");
    }
}

interface MultiPlayerMediator{
    void addPlayer(Player player);
    void sendMovement(Player player,String movement);
}

class MediatorImpl implements MultiPlayerMediator{

    List<Player> playerList = new ArrayList<>();

    @Override
    public void addPlayer(Player player) {
        System.out.println("A player is added");
        playerList.add(player);
    }

    @Override
    public void sendMovement(Player player, String movement) {
        for(Player p : playerList){
            if(p != player){
                p.receiveMovement(movement);
            }
        }
    }
}

abstract class Player{
    String playerName;
    MultiPlayerMediator mediator;

    public Player(MultiPlayerMediator mediator,String playerName){
        this.mediator = mediator;
        this.playerName = playerName;
    }

    abstract void sendMovement(String movement);
    abstract void receiveMovement(String movement);
}

class GamePlayer extends Player{

    public GamePlayer(MultiPlayerMediator mediator, String playerName) {
        super(mediator, playerName);
        mediator.addPlayer(this);
    }

    @Override
    void sendMovement(String movement) {
        System.out.println(this.playerName+" send movement to mediator.");
        mediator.sendMovement(this,movement);
    }

    @Override
    void receiveMovement(String movement) {
        System.out.println(this.playerName+" receive "+movement);
    }
}

