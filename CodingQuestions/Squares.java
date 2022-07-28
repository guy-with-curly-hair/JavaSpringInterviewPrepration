package CodingQuestions;

import java.util.ArrayList;
import java.util.List;

public class Squares {

    //ABC
    //
    public static void main(String[] args) {
        String repeat="ABCDEAB";
        List<String> op = new ArrayList<>();
        char[] ch = repeat.toCharArray();
        int[] all = new int[256];

        op.forEach(i -> System.out.println(i));
    }
}
