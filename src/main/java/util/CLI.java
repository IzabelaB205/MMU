package util;

import server.IObserverServer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CLI implements Runnable, IObservableCLI{
    private final BufferedReader inputReader;
    private final PrintWriter outputWriter;
    private boolean state = true;
    private List<IObserverServer> observers;

    public CLI(InputStream inputStream, OutputStream outputStream) {
        this.inputReader = new BufferedReader(new InputStreamReader(inputStream));
        this.outputWriter = new PrintWriter(outputStream);
        observers = new ArrayList<>();
    }

    @Override
    public void run() {
        String command = "";

        while(!command.equals("shutdown")) {
            try {
                outputWriter.println("Enter command:");
                outputWriter.flush();

                command = inputReader.readLine();

                if(command.equals("start")) {
                    setState(true);
                }
                else if(command.equals("stop")) {
                    inputReader.close();
                    setState(false);
                }
                else {
                    outputWriter.println("wrong command");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                outputWriter.close();
            }
        }
    }

    private void setState(boolean state) {
        this.state = state;
        notifyObserver();
    }

    @Override
    public void add(IObserverServer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserverServer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(IObserverServer observerServer : observers) {
            observerServer.update(state);
        }
    }
}
