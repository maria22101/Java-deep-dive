package design_patterns.creational_patterns.Singleton;

import java.time.LocalDate;

/**
 * FactoryMethod design pattern implementation
 * Created by Bilous M. 21.01.2020
 */
public class FactoryMethod {
    public static void main(String[] args) {

        WatchMaker watchMaker = new DigitalWatchMaker();
        Watch watch = watchMaker.createWatch();
        watch.showTime();

        WatchMaker maker = getMakerByName("Rome");
        maker.createWatch().showTime();
    }

    public static WatchMaker getMakerByName(String maker) {
        if (maker.equals("Didgital")) {
            return new DigitalWatchMaker();
        } else if (maker.equals(("Rome"))) {
            return new RomeWatchMaker();
        }

        throw new RuntimeException(maker + " product line not being supported");
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println(LocalDate.now());
    }
}

class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}
