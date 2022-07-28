package CodingQuestions;

import java.util.ArrayList;
import java.util.List;

public class Stringpermute {

    //ABC
    //
    public static void main(String[] args) {
        String word = "ABCD";
        List<String> op = new ArrayList<>();
        permute(word,0,op);
        op.forEach(i -> System.out.println(i));
    }

    private static void permute(String word , int start, List<String> op) {

        for ( int i =start; i < word.length(); i++)
        {
            if ( start == word.length()-1)
                op.add(word);

            String newword = swaps( word, start, i);
            permute(newword,start +1,op);
            //swap start with i with start
            //permute(
        }
    }

    private static String swaps(String word, int start, int i) {

        char[] ch = word.toCharArray();
        char temp = ch[start];
        ch[start]=ch[i];
        ch[i]=temp;
        return String.valueOf(ch);
    }
}
