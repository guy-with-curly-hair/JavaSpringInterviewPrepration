package CodingQuestions;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class StringSplit {

    public static void main(String[] args)
    {

        String path = "/foo/../test/../test/../foo//bar/./baz";
        String[] input = path.split("/");
        Stack<String> s1 = new Stack();

        for( String s : input)
        {
            if(s.isEmpty() || s.isBlank() || s.equalsIgnoreCase("."))
                continue;
            if(s1.isEmpty())
            {
                s1.push(s);
            }
            else
            {
                if (s.equalsIgnoreCase(".."))
                    s1.pop();
                else
                    s1.push(s);
            }

            int[] a = new int[5];

        }
        String op = s1.stream().collect(Collectors.joining("/","/","/"));
        System.out.println("VT");
    }
}
