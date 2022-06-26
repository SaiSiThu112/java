package designPatternTest.creationalDP;

class Eg{
    String map;
    String tick;
    String gun;
    String partyMember;

    static class Builder{

        String map;
        String tick;
        String gun;
        String partyMember;

        Builder map(String map){
            this.map=map;
            return this;
        }
        Builder tick(String tick){
            this.tick=tick;
            return this;
        }
        Builder gun(String gun){
            this.gun=gun;
            return this;
        }
        Builder partyMember(String partyMember){
            this.partyMember=partyMember;
            return this;
        }
        Eg build(){
            Eg eg = new Eg(this );
            return eg;
        }
    }
      private Eg(Builder builder){
        this.map=builder.map;
        this.tick=builder.tick;
        this.gun=builder.gun;
        this.partyMember= builder.partyMember;
    }
    @Override
    public String toString() {
        return "Eg{ " +" map = " + map + ", tick = " + tick + ", gun = " + gun + ", partyMember = " + partyMember + " }";
    }
}

public class BuilderEg {
    public static void main(String[] args) {
        Eg eg = new Eg.Builder().map("Mirage").tick("128").gun("AK47").partyMember("Full").build();
        System.out.println(eg);
    }
}
