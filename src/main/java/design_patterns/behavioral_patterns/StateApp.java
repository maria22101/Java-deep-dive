package design_patterns.behavioral_patterns;

public class StateApp {
    public static void main(String[] args) {
        State open = new Open();
        Door door = new Door();
        door.setState(open);

        for (int i = 0; i < 6; i++) {
            door.move();
            door.changeState();
        }
    }
}

// Depending on the Door state we either open it (if it is closed) or close it (if it is open)
class Door {
    private State state;

    void setState(State state) {
        this.state = state;
    }

    void changeState() {
        if (state instanceof Open) {
            setState(new Close());
        }else if (state instanceof Close) {
            setState(new Open());
        }
    }

    void move() {
        state.openClose();
    }
}

interface State {
    void openClose();
}

class Open implements State {
    @Override
    public void openClose() {
        System.out.println("The door is open");
    }
}

class Close implements State {
    @Override
    public void openClose() {
        System.out.println("The door is closed");
    }
}