package mid;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    int l=0, r=1;
    int max = 0;
    List<Character> a = new ArrayList<>();
    while(r<s.length()){
      int idx = a.indexOf(s.charAt(r));
      a.add(s.charAt(r));

      if(idx >= 0){
        l=idx;
        a.subList(0, idx+1).clear();
        r++;
      } else {
        r++;
      }
      System.out.println(a);
      max = Math.max(max, a.size());

    }

    return max;

  }
}
