package CodingQuestions;

import java.util.*;
import java.util.stream.IntStream;

public class AlgoExpertmaxSumIncreasingSubsequence {

    public static void main(String[] args) {

        int[] a = new int[]{10,70,20,30,50,11,30};
        maxSumIncreasingSubsequence(a);
    }

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] a) {
        // Write your code here.

        int[] max_sum= new int[a.length];
        List<List<Integer>> list = new ArrayList<>();

        IntStream.range(0,a.length).forEach( i -> max_sum[i]= a[i]);
        IntStream.range(0,a.length).forEach( i ->
        {
            List<Integer> op = new ArrayList<>();
            op.add(a[i]);
            list.add(i,op);  });

        for ( int i =1 ; i < a.length; i++)
        {
            for ( int j =i-1; j>=0 ; j--)
            {
                if (a[i] > a [j] && max_sum[j] + a[i] > max_sum[i]){
                    max_sum[i]= max_sum[j] + a[i];
                    List<Integer> op2 = list.get(j);
                    List<Integer> op1 = new ArrayList<>(op2);
                    op1.add(a[i]);
                    list.set(i,op1);
                }

            }
        }

        int max_value=Arrays.stream(max_sum).max().getAsInt();
        System.out.println(  " max_sum[i] " + max_value);
        int maxIndex= Math.abs(Arrays.binarySearch(max_sum, max_value));
        System.out.println(  " maxIndex[i] " + maxIndex);
        return new ArrayList<List<Integer>>() {
            {
                add(List.of(max_value)); // Example max sum
                add(list.get(maxIndex-1)); // Example max sequence
            }
        };
    }

}
