package testing;

class Product {
    private int id;
    private String name;
    private double price;

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
}

class CreditCard{
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class Person{

    private CreditCard cd;

    public Person(CreditCard cd){
        this.cd=cd;
    }

    public void buy(Product product) throws BalanceNotEnoughException {
        double balance = cd.getBalance();

        if(balance< product.getPrice()){
            throw new BalanceNotEnoughException("Your balance is not enough!");
        }
        else {
            balance-= product.getPrice();
            System.out.println("You have bough "+product.getName()+" and you have "+balance+" left.");
        }
    }
}

class BalanceNotEnoughException extends Exception{

    public BalanceNotEnoughException(String message) {
        super(message);
    }
}
public class test{
    public static void main(String[] args) {
        Product product = new Product();
        product.setId(1);
        product.setName("Mouse");
        product.setPrice(30);

        CreditCard crd = new CreditCard();
        crd.setBalance(50);

        Person prn = new Person(crd);
        try {
            prn.buy(product);
        } catch (BalanceNotEnoughException e) {
            e.printStackTrace();
        }
    }
}

