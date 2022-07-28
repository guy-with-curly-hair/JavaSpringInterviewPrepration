package CodingQuestions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlgoExpert4 {

    public static void main(String[] args) {

        Integer[] a = new Integer[]{10,70,20,30,50,11,30};
        int[] a1 = new int[]{10,70,20,30,50,11,30};
        Arrays.sort(a,Comparator.reverseOrder());
        Arrays.stream(a)
                        .mapToInt( i -> i).toArray();
        Arrays.stream(a1).boxed().collect(Collectors.toList());
        List<Integer> l = new ArrayList<>();

        l.stream().mapToInt( i -> i).toArray();
        maxSumIncreasingSubsequence(a1);
    }

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] a) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        return null;
    }

}
