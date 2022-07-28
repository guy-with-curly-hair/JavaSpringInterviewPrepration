package CodingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class AlgoExpert7 {

    public static void main(String[] args) {

        int[] a = new int[]{5,1,3};


        int num=1;

        int size = a.length;

        if(size <= 0)
        {
            System.out.println( "inside " + "-1");
            return;
        }

        if ( size==1  )
            System.out.println( a[0]==num ? 0 : -1);

        int rotate =  getKindex(a,0,a.length-1);
        System.out.println("rotate " + rotate);
        int position =-1;
        if ( num >= a[rotate] && num <= a[a.length-1])
        {
            position = Arrays.binarySearch(a,rotate,a.length,num);
            System.out.println("inside it " + position);
        }
        else
        {
            position = Arrays.binarySearch(a,0,rotate+1,num);
            System.out.println("outside it " + position);

        }

        System.out.println(position < 0 ? -1 : position);

    }


    static int getKindex( int[] a, int s, int e)
    {
        int mid = s+e/2;
        //base
        if ( mid <= 0  && a[mid] > a[mid+1])
            return mid +1;
        else if ( mid <= 0  && a[mid] < a[mid+1])
            return mid;

        if ( a[mid] > a[mid-1] && a[mid] > a[mid+1])
            return mid+1;

        if (( a[mid] > a[mid-1] && a[mid] < a[mid+1] && a[mid] < a[0]))
            {
                System.out.println(" inside left side ");
                return getKindex(a , s , mid -1);
            }
        else if (( a[mid] > a[mid-1] && a[mid] < a[mid+1] && a[mid] > a[e]))
            return getKindex(a , mid+1, e);
        else
            return 0;
        }


}
