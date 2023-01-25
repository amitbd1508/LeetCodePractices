package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
  // Design an algorithm to encode a list of string  to a string then encoded string is then sent over network and is decoded back to the original list of string
  // input : ["lint", "code", "love", "you"]
  //Output: ["lint", "code", "love", "you"]

  public static void main(String[] args) {
    List<String> in = new ArrayList<>();
    String[] input = new String[] {"4$lint", "code", "love", "you"};
    in.addAll(Arrays.stream(input).toList());
    var x = new EncodeAndDecodeStrings().encode(in);
    var y = new EncodeAndDecodeStrings().decode(x);
    System.out.println(in);
    System.out.println(x);
    System.out.println(y);
    System.out.println(in.equals(y));
  }

  public String encode(List<String> list) {
    StringBuffer buff = new StringBuffer("");
    for (String s: list) {
      buff.append(s.length()+"$" + s);
    }
    return buff.toString();
  }

  public List<String> decode(String s) {
    StringBuffer buff = new StringBuffer(s);
    List<String> res = new ArrayList<>();

    while(buff.length() != 0) {
      String sl = "";
      while(buff.charAt(0) != '$') {
        sl += String.valueOf(buff.charAt(0));
        buff.deleteCharAt(0);
      }
      buff.deleteCharAt(0);
      res.add(buff.substring(0, Integer.valueOf(sl)));
      buff.delete(0, Integer.valueOf(sl));
    }
    return res;
  }
}
