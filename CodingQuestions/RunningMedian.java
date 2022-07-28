package CodingQuestions;

import javax.print.attribute.standard.Media;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class RunningMedian {

    public static void main(String[] args) {
        MedianHandler h = new MedianHandler();
        int a[] = new int[]{11,12,13,14,15,16};
        h.add(a);
        h.add(10);
        double median = h.getMedian();
        System.out.println(median);
        Arrays.sort(a);
        if ( a.length %2 ==0 )
        {

        }

    }


}
 //1 2 3 4 5 max   min  6 7 8 9 10
class MedianHandler{
    PriorityQueue<Integer> min = new PriorityQueue();
    PriorityQueue<Integer> max = new PriorityQueue(Comparator.reverseOrder());

    //max heap is max in minimum element
    //min heal its min in maximum value

     public void add ( int[] arr)
     {
         IntStream.range(0,arr.length).forEach( i -> add(arr[i]));
     }
    public void add( Integer num )
    {
        if ( min.size() ==0)
        {
            min.add(num);
            return;
        }
        if( min.peek() < num )
        {
            min.offer(num);
            if ( min.size() > max.size()+1)
            {
                max.offer(min.poll());
            }
        }
        else {
            max.offer(num);
            if (max.size() > min.size() + 1) {
                min.offer(max.poll());
            }
        }
    }


    public double getMedian()
    {
        if(min.size()>max.size())
            return min.peek();
        else if(min.size() < max.size())
            return  max.peek();
        else
            return (min.peek() + max.peek())/2.0;

    }

}

// 1 2 3 4(maxheap)                     (minheap)5 6 7 8 9