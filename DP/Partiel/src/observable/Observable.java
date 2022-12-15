package observable;

import java.util.ArrayList;

public abstract class Observable {

    ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

}
