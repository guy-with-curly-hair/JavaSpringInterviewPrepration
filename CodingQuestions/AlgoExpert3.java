package CodingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class AlgoExpert3 {
    public static int productSum(List<Object> a) {
        // Write your code here.



        return productSum(a,1);
    }

    public static int productSum(List<Object> a, int depth)
    {
        int rows = a.size();
        int sum=0;
        for( int i =0; i < rows;i++)
        {
            if ( a.get(i) instanceof List<?>){
                List<Object> list = (List<Object>) a.get(i);
                int op= productSum(list,depth+1);
                sum = sum + depth * op;       }
        else
                sum=sum+ (Integer)a.get(i);
            return sum;

        }

        return 0;

    }

}
