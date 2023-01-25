package mid;

public class LongestRepeatingSubstring {
  public int characterReplacement(String s, int k) {
    int ans = 0;
    int mf = 0;
    int[] ch = new int[26];

    int l = 0;
    for (int i = 0; i < s.length(); i++) {
      ch[s.charAt(i)-'A']++;
      mf = Math.max(mf, s.charAt(i)-'A');

      if(i-l+1 - mf > k) {
        //ch[s.charAt(l)-'A']--;
        l++;
      } else  {
        ans = Math.max(ans, i-l+1);
      }
    }

    return ans;
  }

}
