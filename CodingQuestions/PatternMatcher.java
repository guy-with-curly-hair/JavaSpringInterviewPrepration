package CodingQuestions;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class PatternMatcher {

    public static void main(String[] args) {

        Pattern p = Pattern.compile(".*abc");
        //String[] grups = p.split("abcdabcdrtabcyuabc");
        int count = p.matcher("abcdabcdrtabcyuabc").matches() ? p.matcher("abcdabcdrtabcyuabc").groupCount():0;
        //System.out.println(grups);
    }



}
