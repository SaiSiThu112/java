package designPattern.structuralDP;

import java.util.HashMap;
import java.util.Map;

class Code{
    String code;

    public Code(String code){
        this.code= code;
    }

    public void setCode(String code){
        this.code=code;
    }
    public String getCode(){
        return code;
    }

}

interface Platform{
    void execute(Code code);
}

class JavaPlatform implements Platform{
    {
        System.out.println("Create Java Platform");
    }
    @Override
    public void execute(Code code) {
        System.out.println("Execute "+code.getCode()+" on Java");
    }
}

class DotNetPlatform implements Platform{
    {
        System.out.println("Create .Net Platform");
    }
    @Override
    public void execute(Code code) {
        System.out.println("Execute "+code.getCode()+" on .Net");
    }
}

class PlatformFactory {

    private static Map<String , Platform> map = new HashMap<>();
    public static Platform getInstance(String platformType){
        Platform p = map.get(platformType);
        if(p==null){
            switch (platformType){
                case "Java":
                p = new JavaPlatform();
                break;
                case ".Net":
                p = new DotNetPlatform();
                break;

            }
            map.put( platformType, p);
        }
        return p;
    }
}

public class FlyWeight {
    public static void main(String[] args) {
        Code java = new Code("Java program");
        Code dotnet = new Code(".Net program");
        Platform p = PlatformFactory.getInstance(".Net");
        p.execute(dotnet);
        p = PlatformFactory.getInstance("Java");
        p.execute(java);
        p = PlatformFactory.getInstance(".Net");
        p.execute(dotnet);
    }
}
