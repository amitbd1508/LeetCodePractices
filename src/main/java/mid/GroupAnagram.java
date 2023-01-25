package mid;

import java.util.*;

public class GroupAnagram {
  public static void main(String[] args) {
    System.out.println(new GroupAnagram().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
  }
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, ArrayList<String>> map = new HashMap<>();
    for (String s: strs) {
      char [] sorted = s.toCharArray();
      Arrays.sort(sorted);
      String str = new String(sorted);
      System.out.println(map.get(new String(sorted)));
      map.computeIfAbsent(str, k -> new ArrayList<>());

      map.get(str).add(s);
    }

    System.out.println();
    return new ArrayList<>(map.values());

  }
}
