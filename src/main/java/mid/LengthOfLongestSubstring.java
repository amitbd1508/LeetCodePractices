package mid;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
  public static void main(String[] args) {
    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    // a i=0 l=0 res = 1
    //ab i=1 l = 0 res = 2
    //abc i=2 l = 0 res = 3
    // bca i=3 l = 1 res = 3
    // cab i = 4 l = 2 res= 3
    // abc  i = 5 l = 3 res = 3

    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));

    // p i=0 l = 0 res=1
    // pw i=1 l = 0 res=1
    // pw i=2 l = 1 res=2
    // pwk i=3 l = 1 res=3
    // pwk i=3 l = 1 res=3
    // pkw i=4 l = 2 res=3
    // pkwe i=5 l = 2 res=4
    // pkew i=6 l = 3  res=4
  }
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int l = 0, res = 0;
    for (int i = 0; i < s.length(); i++) {
      while(set.contains(s.charAt(i))){
        set.remove(s.charAt(l));
        l++;
      }
      res = Math.max(res, i-l+1);
      set.add(s.charAt(i));
    }

    return res;
  }

}
