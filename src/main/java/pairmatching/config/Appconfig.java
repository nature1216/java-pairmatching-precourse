package pairmatching.config;

import pairmatching.controller.MatchingController;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Appconfig {
    public MatchingController matchingController() {
        return new MatchingController(inputView(), outputView(), matchService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private MatchingService matchService() {
        return new MatchingService();
    }
}
