package companies.advantageglobal;
import java.util.*;

public class SentanceAnagram {
  public static void main(String[] args) {
    System.out.println(new SentanceAnagram().solution("bored cat", "act robed"));

  }


  boolean solution(String s, String t) {
    //s = s.strip();
    //t = t.strip();

    String [] sArr = s.split("\\s");
    String [] tArr = t.split("\\s");

    if(sArr.length != tArr.length) return false;



    Map<String, Integer> map = new HashMap<>();
    for (String x: sArr) {
      char[] charArr = x.toCharArray();
      Arrays.sort(charArr);
      map.put(new String(charArr), 0);
    }

    for (String x: tArr) {
      char[] a = x.toCharArray();
      Arrays.sort(a);
      System.out.println(new String(a));
      if(!map.containsKey(new String(a))) return false;
    }
    return true;
  }
}
