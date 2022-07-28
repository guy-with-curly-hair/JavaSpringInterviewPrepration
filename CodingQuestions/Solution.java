package CodingQuestions;



class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{10,1,2,4,7,2};
        int k=5;
        int op = longestSubarray(a,k);
        System.out.println(op);
    }
    public static int longestSubarray(int[] nums, int k) {
        return getCount(nums,k);
    }
    
      private static int getCount(int[] a, int k) {
        int count=0;
          int maxLen=Integer.MIN_VALUE;
        for ( int i =0; i <a.length; i++)
        {
            for (int j =i ; j <a.length; j++)
            {
               if (checkMinMaxDiffernce(i , j, a) <= k)
               {
                   ++count;
                   if (maxLen < Math.abs(i-j)+1)
                       maxLen= Math.abs(i-j)+1;
               }
            }
        }
        return maxLen;
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