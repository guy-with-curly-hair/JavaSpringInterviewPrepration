package CodingQuestions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CoinChange {

    public static void main(String[] args) {

        int[] a = new int[]{ 1,2,4,5,6,7,8,9,11};
        int sum =27 ;
        List<List<Integer>> op = new ArrayList<>();
        List<Integer> interOp = new ArrayList<>();
        //coinChange(a, a.length-1, sum, interOp , op);
        coinChange1(a, a.length-1, sum, interOp , op);
        dpCoinChangeWays(a, a.length-1,sum );
        dpCoinChangeWays1(a, a.length-1,sum);

        System.out.println("recursive " + op);

    }
    // f(i)   --> Min (i chosee || or not i)
    //recurssion
    private static void coinChange(int[] a, int len,  int sum, List<Integer> op,List<List<Integer>> finalop) {
        if ( sum == 0) {
            finalop.add(new ArrayList<>(op));
            return ;
        }
        if ( len <= 0 || sum < 0)
        return ;
        Integer nextInput = a[len];
        op.add(nextInput);
        coinChange(a,len-1,sum -a[len], op,finalop);
        op.remove(nextInput);
        coinChange(a,len-1,sum , op,finalop);
        }

    //recurssion
    private static void coinChange1(int[] a, int len,  int sum, List<Integer> op,List<List<Integer>> finalop) {
        if ( sum == 0) {
            finalop.add(new ArrayList<>(op));
            return ;
        }
        if ( len < 0 || sum < 0)
            return ;
        Integer nextInput = a[len];
        op.add(nextInput);
        coinChange1(a,len,sum -a[len], op,finalop);
        op.remove(nextInput);
        coinChange1(a,len-1,sum , op,finalop);
    }

    public static void dpCoinChangeWays( int [] a , int len , int sum )
    {
        int[] table = new int[sum+1];

        Arrays.fill(table,0);
        table[0]=1;
        for ( int i =0; i <= len ; i++)
        {
            for ( int j =a[i] ; j <=sum && j-a[i] >=0 ; j++) {
                table[j] = table[j] + table[j-a[i]];
            }
        }
        System.out.println("DPF count " + table[sum]);

    }
    //5 bana --> list<1,1,1,1,> + list<1,1,2> + List<5>
    public static void dpCoinChangeWays1( int [] a , int len , int sum )
    {
        List<List<Integer>>[] table = new List[sum+1];
        IntStream.rangeClosed(0,sum).forEach(i ->
        {
            table[i] = new ArrayList<>();
        });

        for( int i =0 ; i <=len &&a[i]<= sum;i++)
    {
        int key = a[i];
        List<Integer>  l = new ArrayList<>();
        l.add(key);
        table[key].add(l);
    }

        for ( int i =0; i <= len ; i++)
        {
            for ( int j =a[i] ; j <=sum && j-a[i] >=0 && a[i] <=sum; j++) {
                int finalI = i;
                for ( List<Integer> l : table[j-a[i]])
                {
                    List<Integer> newEntry = new ArrayList<>(l);
                    newEntry.add(a[i]);
                    table[j].add(newEntry);

                }
            }
        }
        System.out.println("DPfOutut with whole output"+ table[sum]);

    }

}

// count ( i , a[].legnth, sum ) = count (

