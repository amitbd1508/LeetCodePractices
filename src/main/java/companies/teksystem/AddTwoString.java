package companies.teksystem;
import static org.junit.Assert.*;
import org.junit.Test;

public class AddTwoString {

  public static void main(String[] args) {
    new AddTwoString().addString(".111", "11.99");
  }



  String addString(String a, String b){

    StringBuilder s1= new StringBuilder(a);
    StringBuilder s2= new StringBuilder(b);

    int n1 = a.length() - 1;
    int n2 = b.length() - 1;

    while(n1 >=0 && a.charAt(n1) != '.'){
      n1 --;
    }

    if(n1 >=0) s1.deleteCharAt(n1);
    while(n2 >=0 && b.charAt(n2) != '.'){
      n2 --;
    }
    if(n2 >=0) s2.deleteCharAt(n2);

    int shift1 = n1<0 ? 0 : a.length()-1-n1;
    int shift2 = n2<0 ? 0 : b.length()-1 -n2;

    int decPoint = Math.max(shift1, shift2);

    for(int i=0; i<decPoint -shift1 ;i++){
      s1.append('0');
    }

    for(int i=0; i<decPoint -shift2 ;i++){
      s2.append('0');
    }

    // add
    s1.reverse();
    s2.reverse();

    if(s1.length() > s2.length()) {
      for (int i = 0; i < s1.length() -s2.length(); i++) {
        s2.append('0');
      }
    }
    else {
      for (int i = 0; i < s2.length() - s1.length(); i++) {
        s1.append('0');
      }
    }

    StringBuilder res = new StringBuilder("");

    int carry = 0;
    for (int i = 0; i < s1.length(); i++) {
      int sum = (int)(s1.charAt(i) - '0') + (int)(s2.charAt(i) - '0') + carry;
      res.append((char) ((sum%10) + '0'));
      carry = sum / 10;
    }

    if(carry > 0) {
      res.append((char) (carry + '0'));
      decPoint--;
    }

    res.reverse();
    if(decPoint > 0) {
      res.insert(s1.length() - decPoint , '.');  // if decimal point 2 then 3 index
    }
    return res.toString();

  }

  @Test
  public void addStringTest(){
    assertNotNull(addString("1","2"));
    assertEquals("Should be equal","23.10", addString("11.11", "11.99"));
    assertEquals("100.10", addString("0.11", "99.99"));
    assertEquals("31", addString("29", "2"));
    assertEquals("1.00", addString("0.01", ".99"));
    assertEquals("100.10", addString("0.11", "99.99"));
    assertEquals("100.10", addString("0.11", "99.99"));
    assertEquals("100.10", addString("0.11", "99.99"));
  }
}
