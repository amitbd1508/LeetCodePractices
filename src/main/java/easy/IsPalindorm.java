package easy;

public class IsPalindorm {
  public static void main(String[] args) {
    System.out.println(new IsPalindorm().isPalindrome(" "));
  }
  public boolean isPalindrome(String s) {

    StringBuffer sb = new StringBuffer(s.toLowerCase().replaceAll("[^a-z0-9]", ""));
    return sb.toString().equals(sb.reverse().toString());
  }
}
