package designPattern.behaviour;

import java.util.ArrayList;
import java.util.List;

interface ChatMediator{

    void addUser(User user);
    void sendMessage(User user , String message);
}

class ChatMediatorImpl implements ChatMediator{
    List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(User user, String message) {
        for(User u : this.users){
            if(u!=null){
                u.receiveMessage(message);
            }
        }
    }
}

abstract class User{
    String userName ;
    ChatMediator mediator;

    public User(String userName , ChatMediator mediator){
        this.userName=userName;
        this.mediator=mediator;
    }
    abstract void sendMessage(String message);
    abstract void receiveMessage(String message);
}

class ChatUser extends User{

    public ChatUser(String userName, ChatMediator mediator) {
        super(userName, mediator);
        mediator.addUser(this);
    }

    @Override
    void sendMessage(String message) {
        System.out.println(this.userName+" send message to mediator "+message);
        mediator.sendMessage(this, message);
    }

    @Override
    void receiveMessage(String message) {
        System.out.println(this.userName+ " receive message "+ message);
    }
}

public class Mediator {
    public static void main(String[] args) {
        ChatMediatorImpl chatMediator = new ChatMediatorImpl();
        User user1 = new ChatUser("userOne",chatMediator);
        User user2 = new ChatUser("userTwo",chatMediator);
        User user3 = new ChatUser("userThree",chatMediator);
        User user4 = new ChatUser("userFour",chatMediator);

        user2.sendMessage("Hi");
    }
}
