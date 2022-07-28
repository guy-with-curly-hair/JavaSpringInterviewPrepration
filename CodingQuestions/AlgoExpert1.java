package CodingQuestions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AlgoExpert1 {

    public static void main(String[] args) {

        System.out.println(levenshteinDistance("xyz","yabd"));
    }

    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.


        int[][] edits = new int[str1.length()+1][str2.length()+1];
        //0 length str1 then its like size of another string to make edits

        


        IntStream.rangeClosed(0, str2.length()).forEach(i -> edits[0][i] = i);
        IntStream.rangeClosed(0, str1.length()).forEach(i -> edits[i][0] = i);

        for(int i =1; i <= str1.length();i++)
        {
            for( int j =1; j<= str2.length();j++)
            {

                if (str1.charAt(i-1)==str2.charAt(j-1))
                    edits[i][j] = edits[i-1][j-1];
                else
                    edits[i][j]= 1 +
                Math.min(
                Math.min(edits[i-1][j] ,
                        edits[i][j-1]),
                edits[i-1][j-1]);

                //Math.min(
                //Math.min(edits[i-1-1][j] ,
                //        edits[i][j-1-1]),
                //edits[i-1-1][j-1-1]);
            }
        }

        return edits[str1.length()][str2.length()];
    }

    static int valid(int[][] edits, int i, int j)
    {
        if( i < 0 || j<0)
            return 0;
        else
            return edits[i][j];
    }

}
