package CodingQuestions;

import java.util.*;

public class testArray {

    public static void main( String[] args)
    {
     int[][] a = new int[5][5];
     int[] a1 = new int[7];
     Arrays.sort(a1);
     Arrays.sort(a1);

     //Comparator<int> c = Comparator.comparingInt(((i1,i2)-> Integer.compare(i1,i2)));
        Arrays.stream(a).sorted((o1,o2) -> o1[0]-o2[0]);
        Arrays.sort(a, (o1,o2) -> o1[0]-o2[0]);

        Map<Integer,Integer> map = new HashMap<>();
        map.entrySet().stream().sorted((i1,i2) -> (i1.getValue())-i2.getValue());

        Arrays.stream(a).sorted().sorted();
    }
}
