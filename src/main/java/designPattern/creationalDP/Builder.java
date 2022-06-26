package designPattern.creationalDP;

class Text{
    String name;
    String age;
    String address;
    String city;

    static class  Builder{
        String name;
        String age;
        String address;
        String city;

        Builder name (String name){
            this.name=name;
            return this;
        }
        Builder age (String age){
            this.age=age;
            return this;
        }
        Builder address (String address){
            this.address=address;
            return this;
        }
        Builder city(String city){
            this.city=city;
            return this;
        }
        Text build(){
            Text text = new Text(this);
            return text;
        }
    }
    private Text(Builder builder){
        this.name= builder.name;
        this.age= builder.age;
        this.address= builder.address;
        this.city= builder.city;
    }

    @Override
    public String toString() {
        return "Text [name = " + name + " , age = " + age +", address = " + address +", city = "+ city + "] ";
    }
}

public class Builder {
    public static void main(String[] args) {
            Text text = new Text.Builder().name("John") .age ("21").address("Golden Gate Park").city("San Francisco").build();
            System.out.println(text);
    }
}
