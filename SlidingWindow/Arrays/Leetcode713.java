package SlidingWindow.Arrays;

// 713. Subarray Product Less Than K
public class Leetcode713 {

    // brute - force
    // tc is o(n^2) and sc is o(1).
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1)
            return 0;

        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];

                if (product < k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    // optimal
    // tc is o(n) and sc is o(1).
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1)
            return 0; // Edge case

        int n = nums.length;
        int left = 0;
        int product = 1;
        int count = 0;

        for (int right = 0; right < n; right++) {
            product *= nums[right];

            // Shrink window while product >= k
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // All subarrays ending at 'right' with start in [left, right]
            count += (right - left + 1);
        }

        return count;
    }

}