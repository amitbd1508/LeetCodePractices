package mid;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords692 {
  public static void main(String[] args) {
    System.out.println(new TopKFrequentWords692().topKFrequent(new String[]{"i","love","leetcode", "i","love","coding"}, 2));
    System.out.println(new TopKFrequentWords692().topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
  }

  public List<String> topKFrequent(String[] words, int k) {
    SortedSet<Map.Entry<String, Integer>> sortedset = new TreeSet<Map.Entry<String, Integer>>(
      (e1, e2) -> {
        var comp = Long.compare(e2.getValue(), e1.getValue());
        return (comp == 0) ? 1 : comp;
      });

    SortedMap<String, Integer> map = new TreeMap<>();

    for(String word: words) {
      map.put(word, map.get(word) == null ? 1 : map.get(word) + 1);
    }

    sortedset.addAll(map.entrySet());

    LinkedHashSet res =  sortedset.stream()
      .limit(k)
      .map(x -> x.getKey())
      .collect(Collectors.toCollection(LinkedHashSet::new));
    System.out.println(res);
    return res.stream().toList();

  }
}

