package mid;

import java.util.HashSet;

public class LongestConsecuence {
  public int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i <nums.length ; i++) {
      set.add(nums[i]);
    }

    int best = 0;
    for (int i = 0; i < nums.length; i++) {
      if(!set.contains(nums[i]-1)) {
        int size = 1;
        while(set.contains(nums[i] + size)) {
          size ++;
        }
        best = Math.max(size, best);
      }
    }
    return best;

  }
}
