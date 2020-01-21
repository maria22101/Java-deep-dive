package design_patterns.behavioral_patterns;

public class CommandApp {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User(new StartCommand(computer),
                             new StopCommand(computer),
                             new ResetCommand(computer));

        user.startComputer();
        user.stopComputer();
        user.resetComputer();
    }
}
interface Command {
    void execute();
}
// Receiver
class Computer {
    void start(){
        System.out.println("Start");
    }
    void stop(){
        System.out.println("Stop");
    }
    void reset(){
        System.out.println("Reset");
    }
}
// Particular Command
class StartCommand implements Command{
    Computer computer;
    public StartCommand(Computer computer) {this.computer = computer;}
    @Override
    public void execute() {
        computer.start();
    }
}
class StopCommand implements Command{
    Computer computer;
    public StopCommand(Computer computer) {this.computer = computer;}
    @Override
    public void execute() {
        computer.stop();
    }
}
class ResetCommand implements Command{
    Computer computer;
    public ResetCommand(Computer computer) {this.computer = computer;}
    @Override
    public void execute() {
        computer.reset();
    }
}
// invoker
class User {
    Command start;
    Command stop;
    Command reset;
    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    void startComputer(){
        start.execute();
    }
    void stopComputer(){
        stop.execute();
    }
    void resetComputer(){
        reset.execute();
    }
}
