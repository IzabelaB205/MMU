package main.java.model;

import main.java.controller.IController;
import main.java.view.ActionPayload;

public interface IModel {
    void addObserver(IController controller);
    void removeObserver(IController controller);
    void notifyObservers(ActionPayload<String> actionPayload);
    void updateModelData(ActionPayload actionPayload);
}
