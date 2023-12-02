package pairmatching.view;

import pairmatching.domain.Pair;
import pairmatching.domain.PairList;
import pairmatching.enumeration.NoticeMessage;

public class OutputView {
    public void printMatchingResult(PairList pairList) {
        System.out.println(NoticeMessage.PRINT_MATCHING_RESULT.getMessage());
        for(Pair pair : pairList.getPairs()) {
            pair.printCrewNames();
        }
    }

    public void finishReset() {
        System.out.println(NoticeMessage.FINISH_RESET.getMessage());
        System.out.println();
    }
}
