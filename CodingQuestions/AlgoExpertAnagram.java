package CodingQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlgoExpertAnagram {

    public static void main(String[] args)
    {


        String[] wordArr
                = { "cat", "dog", "tac", "god", "act" };

        List<Pair> pairs = IntStream.range(0, wordArr.length).mapToObj(i -> {
            String word = wordArr[i];
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            return new Pair(i , String.valueOf(ch));
        }).sorted(Comparator.comparing(Pair::getWord)).collect(Collectors.toList());


        pairs.stream().forEach( p -> System.out.println(wordArr[p.getIndex()]));
        //System.out.println(pairs);

    }





}

class Pair{
    public int index;
    public String word;

    Pair(int index, String word)
    {
        this.index = index;
        this.word = word;
    }

    public String getWord() {
        return this.word;
    }

    public int getIndex()
    { return this.index;
    }

}