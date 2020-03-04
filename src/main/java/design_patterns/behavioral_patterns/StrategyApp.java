package design_patterns.behavioral_patterns;

public class StrategyApp {
    public static void main(String[] args) {
        DoorA doorA = new DoorA();

        Strategy open = new OpenA();
        doorA.setStrategy(open);
        doorA.move();

        Strategy close = new CloseA();
        doorA.setStrategy(close);
        doorA.move();
    }
}

class DoorA {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void move() {
        strategy.openClose();
    }
}

interface Strategy {
    void openClose();
}

class OpenA implements Strategy {
    @Override
    public void openClose() {
        System.out.println("The door is open");
    }
}

class CloseA implements Strategy {
    @Override
    public void openClose() {
        System.out.println("The door is closed");
    }
}
