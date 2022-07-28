package CodingQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class countcharacter {

    public static void main(String[] args) {
        String s = "sityynbhititiiiii";
        int count1 = (int) s.chars().filter(c -> c=='i').count();
        System.out.println(count1);

        int[] count =  new int[1];
        IntStream.rangeClosed(0,s.length()-1).forEach( i -> {
            if (s.charAt(i) == 'i')
                count[0]=count[0]+1;
        });

             Arrays.stream(s.split("")).map(String::toLowerCase).collect(groupingBy(i-> i, LinkedHashMap::new,Collectors.counting()));


        Person p = new Person();
        p.setCity(new City("Mumbai"));
        p.setLastName("Tiwari");

        Person p1 = new Person();
        p1.setCity(new City("Delhi"));
        p1.setLastName("Dixit");

        Person p2 = new Person();
        p2.setCity(new City("Mumbai"));
        p2.setLastName("Shinde");

        Person p3 = new Person();
        p3.setCity(new City("Pune"));
        p3.setLastName("bhatt");

        List<Person> people = new ArrayList<>();
        people.add(p);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        System.out.println(count[0]);
        Map<String, Set<String>> namesByCity     = people.stream().collect( groupingBy(Person::getCity,TreeMap::new,mapping(Person::getLastName,toSet())));
        Map<String, List<Person>> namesByCity5     = people.stream().collect( groupingBy(Person::getCity));
        Map<City, Set<String>> namesByCity1     = people.stream().collect( groupingBy(Person::getCity1,HashMap::new,mapping(Person::getLastName,toSet())));


        Map<City,List<String>> map3 = people.stream().collect( groupingBy(Person::getCity1, mapping(Person::getLastName,toList())));

        System.out.println(namesByCity);


        int[] a = {1,1,2,2,3,4,5,5,5,6,6,6,6,6,6,7,8};

         Map<Integer,Long> map = Arrays.stream(a).boxed().collect(groupingBy(i-> i, LinkedHashMap::new, Collectors.counting()));


    }

}

class City
{
    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }

    String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
class Person{
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city.toString();
    }

    public City getCity1() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(lastName, person.lastName) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, city);
    }

    String lastName;
    City city;
}

