package main.java.view;

import main.java.controller.IController;

public interface IView {
    void start();
    <T> void updateUIData(T t);
    void updateUIStatistic(String payload);
    void addObserver(IController controller);
    void removeObserver(IController controller);
    void notifyObservers(ActionPayload actionPayload);
}
