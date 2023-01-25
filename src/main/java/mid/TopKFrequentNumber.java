package mid;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopKFrequentNumber {
  public static void main(String[] args) {
    System.out.println(    new TopKFrequentNumber().topKFrequent(new int[]{1,1,1,2,2,3}, 2));

    List<Person> p = new ArrayList<>();
    p.add(new Person("amit", 20));
    p.add(new Person("amit", 20));
    p.add(new Person("amit", 40));
    p.add(new Person("amit", 20));
    p.add(new Person("amit", 20));

    OptionalDouble xx = p.stream().mapToInt(pp -> pp.age).average();
    p.stream().reduce(0, (x, el) -> x+el.age, Integer::sum);

  }
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int n: nums) {
      map.merge(n, 1, Integer::sum);
    }
    var res = map.entrySet().stream()
      .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
      .limit(k).map(Map.Entry::getKey).toList().stream().mapToInt(Integer::intValue).toArray();
    System.out.println(res);

    double x = Arrays.stream(nums).average().orElse(0);

    return res;
  }

}

class Person{
  int age;
  String name;
  public Person(String name, int age){
    this.age = age;
    this.name = name;
  }
}
