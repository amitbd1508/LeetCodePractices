package mid;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
  public static void main(String[] args) {
    System.out.println(new CharacterReplacement().characterReplacement("ABAB", 2));
  }
  public int characterReplacement(String s, int k) {
    int l = 0, res = 0;
    Map<Character, Integer> map = new HashMap<>();

    int max = 0;
    for (int r = 0; r <s.length() ; r++) {
      map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);

      //int max = Collections.max(map.values());
      max = Math.max(max , map.get(s.charAt(r)));
      System.out.println(map.values());
      System.out.println(max);
      while ((r-l+1) - max > k) {
        map.put(s.charAt(l), map.get(s.charAt(l))-1);
        l++;
      }
      res = Math.max(res, r-l+1);
    }

    return res;
  }
}
