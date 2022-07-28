package CodingQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaksAssignments {
    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }


        public static void main(String[] args) {
/*        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        List<Pair> ll = new ArrayList();
        Map<AncestralTree, List<Character>> map = new HashMap<AncestralTree, List<Character>>();*/



            Map<Integer, String> map1 = new HashMap<>();
            map1.put(1, "C");
            map1.put(2, "D");
            map1.put(3, "A");
            //.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
            LinkedHashMap<Integer, String> list = map1.entrySet().stream()
                    .sorted((o1, o2) -> (o1.getValue()).compareTo(o2.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(o1,o2)-> o1,LinkedHashMap::new));


            //List<Map.Entry<Integer, String>> list = map1.entrySet().stream().sorted((o1, o2) -> (o1.getValue()).compareTo(o2.getValue())).collect(Collectors.toList());
            System.out.printf("VT ");
      /*  IntStream.range(0, tasks.size()).forEach(i ->
        {
            Pair p = new Pair(tasks.get(i), i);
            ll.add(p);
        });
        ll.sort((o1, o2) -> o1.getValue() - o2.getValue());

        for (int i = 1; i < k; i++) {
            List<Integer> inner = new ArrayList<>();
            inner.add(ll.get(i - 1).getIndex());
            inner.add(ll.get((2 * k) - i).getIndex());
        }*/

        }

        class Pair {
            int value;
            int index;

            Pair(int value, int index) {
                this.value = value;
                this.index = index;
            }

            public int getValue() {
                return this.value;
            }

            public int getIndex() {
                return this.index;
            }
        }
    }
}
