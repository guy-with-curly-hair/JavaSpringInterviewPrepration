package CodingQuestions;

import java.util.*;

public class Average {

    public static void main(String[] args) {

        Map<String,pair> map = new HashMap<>();
        map.values().stream().map(pair::avg).mapToDouble( i -> i).max();

    }

    class pair{
        int count;
        int totalnum;

        public double avg()
        {
            return (double) totalnum/count;
        }
    }
}
