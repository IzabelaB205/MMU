package main.java.driver;

import main.java.controller.CacheUnitController;
import main.java.controller.IController;
import main.java.model.CacheUnitModel;
import main.java.model.IModel;
import main.java.view.CacheUnitView;
import main.java.view.IView;

public class Driver {
    public static void main(String[] args) {
        IModel model = new CacheUnitModel();
        IView view = new CacheUnitView();
        IController controller = new CacheUnitController(model, view);
        model.addObserver(controller);
        view.addObserver(controller);
        view.start();
    }
}
