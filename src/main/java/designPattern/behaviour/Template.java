package designPattern.behaviour;

abstract class FrameWorkAction{
    private void auth(){
        System.out.println("Authentication");
    }
    private void logging(){
        System.out.println("Logging");
    }
    protected abstract void businessLogic();

    private void process(){
        this.auth();
        this.businessLogic();
        this.logging();
    }
}

class ReportAction extends FrameWorkAction{

    @Override
    protected void businessLogic() {
        System.out.println("Report business action");
    }
}

class SaleAction extends FrameWorkAction{

    @Override
    protected void businessLogic() {
        System.out.println("Sale business action");
    }
}
public class Template {
    public static void main(String[] args) {
        FrameWorkAction frameWorkAction = new SaleAction();
        frameWorkAction.businessLogic();
        FrameWorkAction action = new ReportAction();
        action.businessLogic();
    }
}
