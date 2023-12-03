package pairmatching.controller;

import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.PairList;
import pairmatching.enumeration.MenuType;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MatchingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MatchingService matchingService;

    public MatchingController(InputView inputView, OutputView outputView, MatchingService matchingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.matchingService = matchingService;
    }

    public void run() {
        readMenu();
    }

    public void readMenu() {
        List<PairList> pairLists = new ArrayList<>();
        while(true) {
            String mode = inputView.readMode();
            if(mode.equals(MenuType.EXIT.getMode())) {
                break;
            }
            execute(mode, pairLists);
        }
    }
    public void execute(String mode, List<PairList> pairLists) {
        if (mode.equals(MenuType.PAIR_MATCHING.getMode())) {
            matching(pairLists);
            return;
        }
        if(mode.equals(MenuType.GET_PAIR.getMode())) {
            getPairs(pairLists);
            return;
        }
        if(mode.equals(MenuType.RESET_PAIR.getMode())) {
            reset(pairLists);
        }
    }
    public void reset(List<PairList> pairLists) {
        pairLists.clear();
        outputView.finishReset();
    }

    public void getPairs(List<PairList> pairLists) {
        String input = inputView.readPairMatching();
        PairList pairs = matchingService.getPair(pairLists, input);
        outputView.printMatchingResult(pairs);
    }

    public void matching(List<PairList> pairLists) {
        String input = inputView.readPairMatching();
        if(matchingService.isExist(input, pairLists)) {
            String yesOrNo = inputView.readRematchOrNot();
            if(yesOrNo.equals("아니오")) {
                return;
            }
            pairLists.remove(matchingService.getPairListIndex(input, pairLists));
        }
        PairList pairs = matchingService.pairMatching(input);
        while(!matchingService.canMakePair(pairLists, pairs)) {
            pairs = matchingService.pairMatching(input);
        }
        pairLists.add(pairs);
        outputView.printMatchingResult(pairs);
    }
}
