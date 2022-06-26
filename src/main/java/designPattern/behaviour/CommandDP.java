package designPattern.behaviour;

import java.util.ArrayList;
import java.util.List;

interface ICommand{
    void execute();
}

class CopyCommand implements ICommand{

    @Override
    public void execute() {
        System.out.println("Copy executed");
    }
}

class EditCommand implements ICommand{

    @Override
    public void execute() {
        System.out.println("Edit executed");
    }
}

class PasteCommand implements ICommand{

    @Override
    public void execute() {
        System.out.println("Paste executed");
    }
}

class Invoker{

    List<ICommand> history = new ArrayList<>();

    public void Invoker(ICommand command){
        history.add(command);
        command.execute();
    }

    public void undo(){
        int len = this.history.size()-1;
        ICommand command = history.get(len);
        history.remove(len);
        System.out.println("Undo");
        command.execute();
    }
}
public class CommandDP{
    public static void main(String[] args) {
        Invoker invo = new Invoker();
        ICommand copy = new CopyCommand();
        invo.Invoker(copy);
        ICommand paste = new PasteCommand();
        invo.Invoker(paste);
        invo.undo();
        invo.undo();
    }
}
