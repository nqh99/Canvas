package app;

import config.Configuration;
import handler.Processor;

public class App {
    public static void main(String[] args) {
        new Processor(
                Configuration.getInstance().getHandler(),
                Configuration.getInstance().getMapper(),
                Configuration.getInstance().getInputReader()).process();
    }
}
