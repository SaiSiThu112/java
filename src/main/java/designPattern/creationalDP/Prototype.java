package designPattern.creationalDP;

interface Type extends Cloneable{
    Type reproduce();
}

class HeavyObject implements Type{

    String mysql;
    String oracle;

    static String getMysql(){
        return "mysql database";
    }
    static String getOracle(){
        return "oracle database";
    }

    public HeavyObject() {
        this.mysql=HeavyObject.getMysql();
        this.oracle=HeavyObject.getOracle();
    }

    @Override
    public String toString() {
        return "HeavyObject {" +
                "mysql ='" + mysql + '\'' +
                ", oracle ='" + oracle + '\'' +
                '}';
    }

    @Override
    public Type reproduce() {
        try {
            Type type = (Type)super.clone();
            HeavyObject type2 = (HeavyObject) type;
            return  type2;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
public class Prototype {
    public static void main(String[] args) {
        HeavyObject obj = new HeavyObject();
        HeavyObject obj2 = (HeavyObject) obj.reproduce();
        System.out.println(obj2);
    }
}
