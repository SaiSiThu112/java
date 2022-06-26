package designPatternTest.behaviourDP;

class Item{
    int totalAmount;
    public Item (int totalAmount){
        this.totalAmount = totalAmount;
    }
}

abstract class ItemHandler{
    static final int baseAmount = 1;

    ItemHandler handler;

    public void setItemHandler(ItemHandler handler){
        this.handler= handler;
    }
    public ItemHandler getItemHandler(){
        return handler;
    }
    abstract void totalItem(Item itemAmount);
}

class PhoneStore extends ItemHandler{

    static final int phStoreAmount = baseAmount * 10;

    @Override
    void totalItem(Item itemAmount) {
        if(itemAmount.totalAmount<=phStoreAmount){
            System.out.println("Sale handle by PhoneStore");
        }
        else{
            if(this.getItemHandler()!=null){
                handler.totalItem(itemAmount);
            }
        }
    }
}

class ShowRoom extends ItemHandler{
    static final int showRoomAmount = baseAmount * 20;
    @Override
    void totalItem(Item itemAmount) {
        if(itemAmount.totalAmount<=showRoomAmount){
            System.out.println("Sale handle by ShowRoom");
        }
        else {
            if(this.getItemHandler()!=null){
                handler.totalItem(itemAmount);
            }
        }
    }
}

class Company extends ItemHandler{
    static final int companyAmount = baseAmount * 30;
    @Override
    void totalItem(Item itemAmount) {
        if(itemAmount.totalAmount<=companyAmount){
            System.out.println("Sale handle by Company");
        }
        else {
            if(this.getItemHandler()!=null){
                handler.totalItem(itemAmount);
            }
        }
    }
}
public class CORTest {
    public static void main(String[] args) {
        PhoneStore pStore = new PhoneStore();
        ShowRoom sr = new ShowRoom();
        Company cy = new Company();
        pStore.setItemHandler(sr);
        sr.setItemHandler(cy);

        Item item = new Item(10);
        pStore.totalItem(new Item(50));
        pStore.totalItem(new Item(30));
        pStore.totalItem(new Item(5));
    }
}
