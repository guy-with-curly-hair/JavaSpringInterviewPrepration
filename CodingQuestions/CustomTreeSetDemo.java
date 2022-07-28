package CodingQuestions;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomTreeSetDemo {
 public static void main(String[] args) {

	 Comparator<Cricketer> comp  = (o1,o2) -> o1.getBattingPosition()-o2.getBattingPosition();
	 Comparator<Cricketer> comp1  = Comparator.comparing(Cricketer::getName).thenComparing(Cricketer::getBattingPosition);

	 TreeSet<Cricketer> playerSet = new TreeSet<Cricketer>(comp1);
	playerSet.add(new Cricketer("Sachin", 1));
	playerSet.add(new Cricketer("Sachin", 9));
	playerSet.add(new Cricketer("Mahi", 7));
	playerSet.add(new Cricketer("Bhajji", 8));
	playerSet.add(new Cricketer("Viru", 2));
	playerSet.add(new Cricketer("Gautam", 4));
	playerSet.add(new Cricketer("Ishant", 10));
	playerSet.add(new Cricketer("Umesh", 11));
	playerSet.add(new Cricketer("Pathan", 5));
	playerSet.add(new Cricketer("Virat", 3));
	playerSet.add(new Cricketer("Raina", 6));
	Iterator<Cricketer> it = playerSet.iterator();
	while (it.hasNext()) {
	System.out.println(it.next().getName());
    }
  }
	public static void moveElementToEnd(List<Integer> a, int toMove) {

		BiFunction<Integer,Integer,Integer> f1 = (o1,o2) -> o1+o2;
		Function<Integer,Integer> f4 = (o1) -> o1+2;

		BiFunction<Integer,Integer,Integer> f2 =(o1,o2) -> (o1*o2)/100;

		BiFunction<Integer,Integer,Integer>  f3 = f2.andThen(f4);
		f2.apply(1,f1.apply(1,2));
		Supplier<LinkedHashMap> b1 = LinkedHashMap::new;


		int[][] a1 = new int[10][10];
		List<Integer[]> l = new ArrayList<>();
		l.stream().sorted( (o1, o2) -> o1[0]-o2[0]);
		Stream<int[]> s = Arrays.stream(a1).sorted((o1, o2) -> o1[0]-o2[0]);
		List<int[]> n = s.collect(Collectors.toList());

		//f1 --> x,y
		//f2 -->
	}
}