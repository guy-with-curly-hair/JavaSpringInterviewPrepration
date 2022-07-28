package CodingQuestions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlgoExpertInsertionSort {

    public static void main(String[] args) {

        int[] a = new int[]{10,70,20,30,50,11,30};
        List<Integer> list = new ArrayList<>();
        List<Integer> l = Arrays.stream(a).boxed().sorted().collect(Collectors.toList());

        insertionSort(l,15);
    }

    public static void insertionSort(List<Integer> l, int number) {
        int pos = Collections.binarySearch(l, number);
        if(pos >0)
            return;
        pos = Math.abs(pos);
        int len = l.size()-1;
        l.add(number);
        while(len>=pos-1)
        {
            l.set(len+1,l.get(Math.abs(len)));
            len--;
        }
        l.set(pos-1,number);
        System.out.println(pos);
    }
    }


