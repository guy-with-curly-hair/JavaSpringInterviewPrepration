package CodingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class StringUniqueCharacter {

    public static void main(String[] args) {

        String[] s = {"this", "that", "did", "deed", "them!", "a"};

        minimumCharactersForWords(s);
    }


    public static char[] minimumCharactersForWords(String[] words) {
        // Write your code here.

        Map<Character,Integer> charsCount = new HashMap<>();
        for ( String s : words)
        {
            char[] ch = s.toCharArray();
            Map<Character,Integer> localcharsCount = new HashMap<>();
            for ( char c : ch)
            {
                if ( localcharsCount.containsKey(c))
                {
                    int val = localcharsCount.get(c);
                    val =val+1;
                    localcharsCount.put(c,val);
                }
                else
                localcharsCount.put(c,1);
            }

            for (Character character : localcharsCount.keySet()) {

                if ( charsCount.containsKey(character))
                {
                    int val = localcharsCount.get(character);
                    int val1 = charsCount.get(character);
                    if ( val > val1) {
                        charsCount.put(character, localcharsCount.get(character));
                    }
                }
                else
                {
                    charsCount.put(character, localcharsCount.get(character));
                }

            }
        }
        String s="";
        for (Character k : charsCount.keySet()) {
            int val = charsCount.get(k)   ;
            while ( val > 0 )
            {
                s=s+ k;
                --val;

            }
        }

    return s.toCharArray();

    }

}
