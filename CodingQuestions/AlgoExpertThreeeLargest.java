package CodingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class AlgoExpertThreeeLargest {

    public static void main(String[] args) {

        //int[] a = new int[]{10,70,20,30,50,11,30};
        //int[] a = new int[]{140,1,2,30,50,130,129};

        int[] a = new int[]{140,25,28,30,50,130,129};

        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        for ( int i =0; i < a.length;i++)
        {
            int curr = a[i];
            if ( pq.size() < 3)
                pq.add(curr);
            else if ( pq.peek() < curr)
            {
                pq.poll();
                pq.offer(curr);
            }
        }
        System.out.println(pq);
    }


}
