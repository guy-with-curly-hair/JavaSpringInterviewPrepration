package CodingQuestions;


import java.util.*;
import java.util.stream.IntStream;

public class substringUtil {

    public static void main(String[] args) {
        String s1 = "stephenfernandes";
        String s2= "sph";
        Map<Character, List<Integer>> map= new HashMap<>();
        IntStream.rangeClosed(0,s1.length()-1).forEach( i -> {
            char key = s1.charAt(i);
            if ( s2.indexOf(key) != -1) {
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(i);
                System.out.println("char " + s1.charAt(i) + "  index " + i);
            }
        });

        List<List<Integer>> op = new ArrayList<>();
            char key = s2.charAt(0);
            List<Integer> all = map.get(key);
            for( Integer k : all) {  //o(1) worrstcase o(n)
                List<Integer> finall = new ArrayList<>();
                finall.add(k);
                for (int j = 1; j < s2.length(); j++) {
                    //o(s2)
                    char key2 = s2.charAt(j);
                    List<Integer> pos = map.get(key2);
                    int index = closest(k, pos);
                    finall.add(index);
                }
                Collections.sort(finall);
                op.add(finall);
            }
        System.out.println(op);
        op.stream().forEach( list -> {
            System.out.println( s1.substring( list.get(0), list.get(list.size()-1)+1));
        });

    }
    //a
    //2 5 /6
    //2  best closest for other chacter
    //5
    //6

 private static int closest(int i, List<Integer> pos) {

int min = Integer.MAX_VALUE;
int index = Integer.MAX_VALUE;
for ( Integer k : pos)
{
    if (Math.abs(k -i) < min) {
        min = Math.abs(k -i) ;
        index = k;
    }
}
        return index;
    }

}




