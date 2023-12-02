package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.enumeration.NoticeMessage;
import pairmatching.validator.Validator;

public class InputView {
    public String readMode() {
        System.out.println(NoticeMessage.READ_MODE.getMessage());
        String mode = Console.readLine();
        System.out.println();
        return mode;
    }

    public String readPairMatching() {
        System.out.println(NoticeMessage.READ_PAIR_MATCHING.getMessage());
        String input = Console.readLine();
        try{
            Validator.validateInput(input.replaceAll("\\s", ""));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readPairMatching();
        }
        return input.replaceAll("\\s", "");
    }

    public String readRematchOrNot() {
        System.out.println(NoticeMessage.REMATCH_OR_NOT.getMessage());
        String input = Console.readLine();
        System.out.println();

        return input;
    }
}
