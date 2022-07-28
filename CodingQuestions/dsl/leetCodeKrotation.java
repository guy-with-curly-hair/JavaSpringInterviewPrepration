package CodingQuestions.dsl;

import java.util.Arrays;

public class leetCodeKrotation {
    public static void main(String[] args) {

        int a[]  = new int[]{4,5,6,7,8,1,2,3};
        int k=8;
        search(a,k);
    }

    public static  int search(int[] a, int num) {

        int size = a.length;
        if(size <= 0)
            return -1;

        if ( size==1  )
            return a[0]==num ? 0 : -1;

        int rotate = getKindex(a,0, a.length-1,num);
        System.out.println("rotate index " + rotate);
        int position =-1;

        if ( num >= a[rotate] && num <= a[a.length-1])
            position = Arrays.binarySearch(a,rotate,a.length,num);

        else
            position = Arrays.binarySearch(a,0,rotate,num);

        System.out.println("position " + position);
        return position < 0 ? -1 : position;
    }
//{4,5,6,7,0,1,2,3};
    static int getKindex( int[] a, int s, int e, int num)
    {
        while( s<=e){
            int mid = (s+e)/2;

            if (a[mid] == num)
                return mid ;

            if ( a[s] >num && a[mid] > num && num <= a[e])
                s=mid+1;
            else if ( num < a[s] && (num > a[mid] && num <= a[e]))
                s=mid+1;
            else if ( num <= a[s] && (num > a[mid] && num >= a[e]))
                e=mid-1;
            else if ( num >= a[s] && num <= a[mid])
                e=mid-1;
            else if ( a[s] <num && a[mid] < num && num <= a[e])
                s=mid+1;
            else
                return -1;


        }
        return -1;
    }
}
