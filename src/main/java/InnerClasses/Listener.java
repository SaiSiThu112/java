package InnerClasses;
class View{
    private OnClickListener onClickListener;

    interface OnClickListener{
        void onClick();
    }
    void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }

}
class TextView extends View{
    public void setText(String text){
        System.out.println(text);
    }
}
class Button extends TextView{

}
class Activity{
    private View.OnClickListener listener;

    public void onCreate(){
        Button btn = new Button();
        btn.setText("Login");
        btn.setOnClickListener(listener= new View.OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("Login button is on clicked!");
            }
        });
    }
   public void onClickLogInBtn(){
        listener.onClick();
    }

}
public class Listener {
    public static void main(String[] args) {
        Activity activity = new Activity();
        activity.onCreate();
        activity.onClickLogInBtn();
    }
}
