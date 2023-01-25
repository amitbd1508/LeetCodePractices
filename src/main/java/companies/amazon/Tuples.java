package companies.amazon;

import java.util.*;
import java.util.stream.Stream;

/*
Suppose you are given Amazon product search logs that contain tuples of product IDs,
EG: (9,5). Products in each tuple are related and are considered to form a group.
Given ’n’ such tuples, can you write a function in the programming language
of your choice to determine the number of groups that can be formed?

You may assume that you are given an integer ’numProducts’, representing number of
products in the search log, and that ID ranges from 1 to ’numProducts’.
* */
class Pair{
  int key;
  int value;

  public Pair(int key, int value) {
    this.key = key;
    this.value = value;
  }
}
public class Tuples {
  public static void main(String[] args) {
    System.out.println(
      new Tuples().numOfGroup2(
        Stream.of(new Pair(1, 2), new Pair(3, 7), new Pair(5,8), new Pair(2,5), new Pair(4, 5))
        .sorted(Comparator.comparingInt(x ->x.key))
          .toList(), 7)
    );


  }

  int numOfGroup2(List<Pair> tuples, int numberOfItems) {
    Map<Integer, Set<Integer>> res = new HashMap<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < tuples.size(); i++) {
      Pair p = tuples.get(i);
      if(map.containsKey(p.key) || map.containsKey(p.value)) {
        int min = Math.max(map.getOrDefault(p.key, -1), map.getOrDefault(p.value, -1));
        res.get(min).add(p.key);
        res.get(min).add(p.value);
        map.put(p.key, min);
        map.put(p.value, min);
      } else {
        map.put(p.key, i);
        map.put(p.value, i);
        Set<Integer> set = new HashSet<>();
        set.add(p.key);
        set.add(p.value);
        res.put(i, set);

      }
    }
    res.forEach((key, value) -> System.out.println(Arrays.toString(value.toArray())));
    return res.size();
  }
  int numOfGroup(List<Pair> tuples, int numberOfItems) {
    Set<Integer>[] ls = new HashSet[numberOfItems+1];
    for (int i = 1; i <= numberOfItems; i++) {
      ls[i] = new HashSet<>();
    }

    for(Pair p : tuples) {
      ls[p.key].addAll(List.of(p.key, p.value));
      ls[p.value].addAll(List.of(p.key, p.value));
    }

    Set<Integer>[] ss = new HashSet[numberOfItems+1];
    int count = 1;

    for (int i = 1; i <= numberOfItems; i++) {
      if(ls[i].size() ==0) continue;
      int idx = -1;
      for (int j = 1; j <= count ; j++) {
        if (ss[j] != null && ss[j].contains(i)) {
          idx = j;
          break;
        }
      }
      if(idx> 0) {
        ss[idx].addAll(ls[i].stream().toList());
        if(ss[count] == null) {
          ss[count] = new HashSet<>();
        }
        for(Integer x: ss[count]) {
          ls[x] = new HashSet<>();
        }
      } else {
        if(ss[count] == null) {
          ss[count] = new HashSet<>();
        }
        ss[count].addAll(ls[i]);

        for(Integer x: ss[count]) {
          ls[x] = new HashSet<>();
        }
        count++;
      }


    }
    System.out.println("=======");
    for (int i = 1; i <=count; i++) {
      System.out.println(i + " - "+ss[i]);
    }

    System.out.println("=======");


//    Set<Integer>[] arr = new ArrayList[numberOfItems + 1];
//    int count = 0;
//    for (int i = 1; i <= numberOfItems; i++) {
//      Set<Integer> x = ls.get(i);
//      if (count ==0) {
//        arr[0].addAll(x.);
//        continue;
//      }
//      for (int j = 0; j <=count; j++) {
//        if(arr[j].contains(i))
//      }
//    }

    return count;
  }

  public int numGroups(List<Pair> tuples, int num_products) {
    // Create a set for each product
    Set<Integer>[] productSets = new Set[num_products];
    int[][] p = new int[5][6];
    for (int i = 0; i < num_products; i++) {
      productSets[i] = new HashSet<>();
    }

    // For each tuple, add the products to their respective sets
    for (Pair tuple : tuples) {
      int product1 = tuple.key;
      int product2 = tuple.value;
      productSets[product1 - 1].add(product1);
      productSets[product2 - 1].add(product2);
    }

    System.out.println(Arrays.toString(productSets));

    // Count the number of sets that have more than one element
    int count = 0;
    for (Set<Integer> set : productSets) {
      if (set.size() > 1) {
        count++;
      }
    }
    return count;
  }
}
