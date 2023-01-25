package mid;

public class ProductArray {
  class Solution {
    public int[] productExceptSelf(int[] nums) {
      int total = 1;
      int zc = 0;
      for (int i = 0; i < nums.length; i++) {
        if(nums[i] == 0) {
          zc++;
        } else {
          total = total* nums[i];
        }
        if(zc > 1) {
          total = 0;
          break;
        }
      }
      for (int i = 0; i <nums.length ; i++) {
        if(zc > 1) {
          nums[i] = 0;
        } else {
          if(nums[i] == 0 && zc == 1) {
            nums[i] = total;

          }else if(zc == 1) {
            nums[i] = 0;
          }
          else {
            nums[i] = total/nums[i];
          }
        }
      }
      return nums;
    }
  }

}
