package main.java.view;

import main.java.controller.IController;

import java.util.ArrayList;
import java.util.List;

public class CacheUnitView implements IView{
    private List<IController> observersList;
    private CacheUnitClientFrame frame;

    public CacheUnitView() {
        observersList = new ArrayList<>();
    }

    @Override
    public void start() {
        frame = new CacheUnitClientFrame(this); //creates a frame
    }

    @Override
    public <T> void updateUIData(T t) {
        String content = (String) t;
        frame.updateUIData(content);
    }

    @Override
    public void updateUIStatistic(String payload) {
        frame.updateStatisticPanel(payload);
    }

    @Override
    public void addObserver(IController controller) {
        observersList.add(controller);
    }

    @Override
    public void removeObserver(IController controller) {
        observersList.remove(controller);
    }

    @Override
    public void notifyObservers(ActionPayload actionPayload) {
        for(IController controller : observersList) {
            controller.update(this, actionPayload);
        }
    }
}
