package Arrays;

public class Leetocode11 {

    // brute- force.
    // tc is o(n^2) and sc is o(1).
    public static int mostWaterBruteForce(int[] arr) {
        int n = arr.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = Math.min(arr[i], arr[j]) * (j - i);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    // optimal solution
    // tc is o(n) and sc is o(1).
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int water = Integer.MIN_VALUE;

        while (left <= right) {
            int curntArea = Math.min(height[left], height[right]) * (right - left);
            water = Math.max(water, curntArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {

    }
}