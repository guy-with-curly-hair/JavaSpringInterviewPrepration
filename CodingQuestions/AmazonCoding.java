package CodingQuestions;

public class AmazonCoding {


    public static void main(String[] args) {
        int a[] = new int[]{1,3,6};
        int k =1;
        int op = getCount(a,k);
        System.out.println(op);
    }

    private static int getCount(int[] a, int k) {
        int count=0;
        for ( int i =0; i <a.length; i++)
        {
            for (int j =i ; j <a.length; j++)
            {
               if (checkMinMaxDiffernce(i , j, a) <= k)
                   ++count;
            }
        }
        return count;
    }

    private static int checkMinMaxDiffernce(int i, int j, int[] a) {
        int min= Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while( i <= j)
        {
            if ( a[i] < min)
                min=a[i];
            if(a[i] > max)
                max=a[i];
            i++;
        }
        return Math.abs(max-min);
    }
}
