package main.java.controller;

import main.java.model.IModel;
import main.java.view.ActionPayload;
import main.java.view.IView;

public class CacheUnitController implements IController{
    private IModel model;
    private IView view;

    public CacheUnitController(IModel model, IView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void update(Object o, Object arg) {
        ActionPayload<String> action = (ActionPayload<String>) arg;
        String command = action.getAction();

        switch (command) {
            case "SHOW_STATISTIC":
            case "LOAD_REQUEST":
                model.updateModelData(action);
                break;
            case "UPDATE_VIEW":
                view.updateUIData(action.getPayload());
                break;
            case "UPDATE_STATISTIC_VIEW":
                view.updateUIStatistic(action.getPayload());
                break;
            default:
                break;
        }
    }
}
