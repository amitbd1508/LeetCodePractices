package easy;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      int l = i;
      int r = nums.length-1;
      if(i > 0 && nums[i] == nums[i-1]) continue;
      while(l > r) {
        int total = nums[i-1] + nums[l] + nums[r];
        if(total == 0) {
          res.add(Arrays.asList(nums[i-1], nums[l], nums[r]));
          l++;
          while(nums[l] == nums[l-1] && l<r){
            l++;
          }
        } else if(total < 0) {
          l++;
        } else {
          r--;
        }
      }

    }
    return res;
  }

}
