package pairmatching;

import pairmatching.config.Appconfig;
import pairmatching.controller.MatchingController;

public class Application {
    public static void main(String[] args) {
        Appconfig appconfig = new Appconfig();
        MatchingController matchingController = appconfig.matchingController();
        matchingController.run();
    }
}
