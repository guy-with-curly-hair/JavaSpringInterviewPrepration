package CodingQuestions;

import java.util.*;

public class Palindeome {

    public static void main(String[] args) {

        String palindrom = "abbcbba";
        String palindrom1 = "fgtdabbcbbadm";

        List<String> opt = new ArrayList<>();
        palinUtil(palindrom1.toCharArray(), 0 , palindrom1.length()-1 , opt);
        String max = opt.stream().max((o1, o2) -> o1.length() -o2.length()).toString();
        System.out.println(max);
    }

    public static void palinUtil( char[] word, int s , int e, List<String> op)
        {
            if (s >e)
                return ;
            if ( word[s] == word[e])
            {
               boolean palin = boolPalin( word, s,e);
               if ( palin) {
                  String s1 =  getStringfromChararray( word,s,e);
                  op.add(s1);
                   return;
               }
                palinUtil(word, ++s, --e,op);
            }
            else
            {
                palinUtil(word, ++s,e,op);
                palinUtil(word, s,--e,op);
            }

        }
    private static String getStringfromChararray(char[] word, int s, int e) {
        String op ="";
        while ( s <= e)
        {
            op = op + word[s];
            s++;
        }
   return op;
    }
        private static boolean boolPalin(char[] word, int s, int e) {
        while ( s < e)
        {
            if ( word[s] != word[e])
                return false;
            s++;
            e--;
        }
        return true;
    }

}
