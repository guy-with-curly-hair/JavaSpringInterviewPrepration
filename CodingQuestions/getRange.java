package CodingQuestions;

public class getRange {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,4,5,5,   7,8,8,  8,  9,10,11    };
        getindex(a,0,a.length-1,8, new Integer[2]);

    }


    static int getindex( int[]a, int s, int e,int num, Integer[] op)
    {
        while ( s <= e) {
            int mid = (s + e) / 2;
            if (a[mid] == num) {
                int index = getindex(a, s, mid-1 , num,op);
              int leftIndex = index ==-1 ? mid : Math.min(index,mid);

                int rightIndex = Math.max(mid,getindex(a, mid+1, e , num,op));
                op[0] = leftIndex;
                op[1] = rightIndex;
            } else if (a[mid] > num)
                e = mid - 1;
            else if (a[mid] < num)
                s = mid + 1;
        }
        return -1;
    }

    //7 8 8 8 8 9 10
    //private static int getInnerIndex(int[] a, int s, int e, int num)
    /*{
        if ( s==e)
            return s;

        int mid = (s+e)/2;
        if (a[mid]==num)
        {
            int index = getInnerIndex(a, s, mid-1 , num);
            int leftIndex = index ==-1 ? mid : Math.min(index,mid);

        }
         return getInnerIndex(a,s,mid,num);
        else
           return  getInnerIndex(a,mid+1,e,num);

    }*/


}
