package designPattern.structuralDP;

import java.util.Date;

interface Logger{
    String log(String msg);

}

class BaseLogger implements Logger {

    @Override
    public String log(String msg) {
        return msg;
    }
}

class HTMLDecorator implements Logger{
    Logger logger;

    public HTMLDecorator(Logger logger){
        this.logger=logger;
    }

    @Override
    public String log(String msg) {
        return "<html> " + logger.log(msg) + " <html>";
    }
}

class TimeDecorator implements Logger{

    Logger logger;

    public TimeDecorator(Logger logger){
        this.logger = logger;
    }

    @Override
    public String log(String msg) {
        Date date = new Date();
        return date.toString()+" " + logger.log(msg);
    }
}
public class Decorator {
    public static void main(String[] args) {
            //Logger log = new BaseLogger();
            Logger log = new HTMLDecorator(new TimeDecorator(new BaseLogger()));
            String msg = log.log("LogString");
            System.out.println(msg);
    }
}
