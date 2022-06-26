package designPattern.structuralDP;

interface CommandExecutor{
    void runCommand(String command) throws Exception;
}

class CommandExecutorImpl implements CommandExecutor{

    @Override
    public void runCommand(String command) throws Exception {
        Runtime.getRuntime().exec(command);
        System.out.println("'"+command+" command executed");
    }
}

class CommandExecutorProxy implements CommandExecutor{

    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String user , String password){
        if("admin".equals(user)&&"admin".equals(password)){
            isAdmin=true;
        }
        executor = new CommandExecutorImpl();
    }
    @Override
    public void runCommand(String command) throws Exception {
        if(isAdmin){
            executor.runCommand(command);
        }
        else{
            if(command.trim().startsWith("rm")){
                throw new Exception("rm command is not allowed for non-admin user");
            }
            else {
                executor.runCommand(command);
            }
        }
    }
}
public class Proxy {
    public static void main(String[] args) throws Exception {
        CommandExecutor executor = new CommandExecutorProxy("admin" , "admin");
        executor.runCommand("notepad.exe");
        executor = new CommandExecutorProxy("asdf","asdf");
        executor.runCommand("rm");

    }
}
