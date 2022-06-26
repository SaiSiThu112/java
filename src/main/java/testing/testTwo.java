package testing;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Game{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game(String name) {
        this.name = name;
    }
}

interface Launcher {
    void openGame(Game game);
}

class Steam implements Launcher{

    public Steam(){
        System.out.println("Steam is opened.");
    }

    @Override
    public void openGame(Game game) {
        System.out.println("Opening "+game.name+" with Steam");
    }
}

class Epic implements Launcher{

    public Epic(){
        System.out.println("Epic Launcher is opened.");
    }

    @Override
    public void openGame(Game game) {
        System.out.println("Opening "+game.name+" with Epic Launcher.");
    }
}

class LauncherFactory {
    private static Map<String,Launcher>launcherMap = new HashMap<>();
    public static Launcher getLaucher(String launcherName){

        Launcher l = launcherMap.get(launcherName);
        if (l == null)
        {
            switch (launcherName.toLowerCase(Locale.ROOT)){
                case "steam":
                    l = new Steam();
                    break;

                case "epic":
                    l = new Epic();
                    break;

                default:
                    System.out.println("Application open failed.");
            }
            launcherMap.put(launcherName,l);
        }
        return l;
    }
}

public class testTwo {
    public static void main(String[] args) {
        Game game = new Game("PayDay(2)");
        Launcher launcher = LauncherFactory.getLaucher("Steam");
        launcher.openGame(game);

        Game game1 = new Game("Rocket League");
        launcher= LauncherFactory.getLaucher("Epic");
        launcher.openGame(game1);

        launcher = LauncherFactory.getLaucher("Steam");
        launcher.openGame(game1);

    }
}
