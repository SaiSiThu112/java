package designPatternTest.structuralDP;

import java.util.HashMap;
import java.util.Map;

class Game{
    String game;

    public Game(String game){
        this.game = game;
    }
    public void setGame(String game){
        this.game = game;
    }
    public String getGame(){
        return game;
    }
}

interface Platform{
    void stream(Game game);
}

class Twitch implements Platform{

    {
        System.out.println("Open Twitch ");
    }

    @Override
    public void stream(Game game) {
        System.out.println("Start "+game.getGame()+" streaming");
    }
}

class Youtube implements Platform{

    {
        System.out.println("Open Youtube");
    }

    @Override
    public void stream(Game game) {
        System.out.println("Start "+game.getGame()+" streaming");
    }
}

class PlatformFactory {

    private static Map<String , Platform> map = new HashMap<>();
    public static Platform getInstance(String platformType){
        Platform p = map.get(platformType);
            if(p==null){
                switch (platformType){
                    case "Twitch":
                        p = new Twitch();
                        break;
                    case "Youtube":
                        p = new Youtube();
                        break;
                    default:
                        System.out.println("Connection Interrupted");
                }
                map.put(platformType , p);
            }
            return p;
    }

}
public class FlyWeightTest{
    public static void main(String[] args) {
        Game game = new Game("CounterStrike");
        Game game1 = new Game("Pay Day Two");
        Platform p = PlatformFactory.getInstance("Twitch");
        p.stream(game);
        p = PlatformFactory.getInstance("Youtube");
        p.stream(game1);
        p = PlatformFactory.getInstance("Twitch");
        p.stream(game);

    }
}