package mid;

public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int max = 0;
    int l = 0;
    int r = height.length - 1;
    for (int i = 0; i < height.length; i++) {
      int c = Math.abs(l-r) * Math.min(height[l], height[r]);
      max = Math.max(c, max);
      if(height[l] < height[r]) {
        l++;
      } else {
        r--;
      }

    }
    return max;
  }
}
