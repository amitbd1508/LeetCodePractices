package mid;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
  public  static void main(String[] args) {
    System.out.println(new MinWindowSubstring().minWindow("ADOBECODEBANC","ABC"));
  }
  public int minWindow(String s, String t) {
    int l = 0, res = s.length() + 1;
    Map<Character, Integer> tm = new HashMap<>();
    Map<Character, Integer> tmt = new HashMap<>();
    for (Character c: t.toCharArray()) {
      tm.put(c, tm.getOrDefault(c, 0)+1);
      tmt.put(c, tmt.getOrDefault(c, 0)+1);
    }
    int ts = tm.size();

    Map<Character, Integer> sm = new HashMap<>();

    for (int r = 0; r < s.length(); r++) {
      while (!tmt.containsKey(s.charAt(l))){
        l++;
      }
      if(tm.containsKey(s.charAt(r))){
        sm.put(s.charAt(r), sm.getOrDefault(s.charAt(r), 0)+1);
        if( tmt.get(s.charAt(r)) == sm.get(s.charAt(r)) ){
          tmt.put(s.charAt(r) ,0);
          ts --;
        }


        if (ts == 0) {
          res = Math.min(r-l+1, res);
          System.out.println(s.substring(l, r+1));

          //ts++;

          if(tmt.containsKey(s.charAt(l))){
            sm.put(s.charAt(l), sm.get(s.charAt(l))-1);
            tmt.put(s.charAt(l), 1);
            ts++;
            l++;
          }
          while (!tmt.containsKey(s.charAt(l)) &&  l<r){
            l++;
          }


        } else
        if( l+tmt.size()<r && r == s.length() -1) {
          r--;
          l++;
          System.out.println(r);
        }
      }


    }
    return res;
  }
}
