package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Leetcode15 {

    // brute-force
    // tc is o(n^3) for loops, sc is o(n) for hashset.
    public static ArrayList<ArrayList<Integer>> threeSum(int[] arr) {

        int n = arr.length;
        HashSet<ArrayList<Integer>> ansSet = new HashSet<>(); // Use Set to avoid duplicates

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        ArrayList<Integer> temp = new ArrayList<>(); // Create NEW list each time
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        Collections.sort(temp); // Sort to handle duplicates like [-1,0,1] and [0,-1,1]
                        ansSet.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(ansSet); // Convert Set back to ArrayList
    }

    // optimal, the algo instead of three loops 1 loop + twosum technique.
    // tc is o(n^2) and sc is o(n).
    public static List<List<Integer>> threeSum2(int[] arr) {

        // sort the array.
        Arrays.sort(arr);

        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            // skip the duplicate i element.
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) { // Added while loop
                int sum = arr[i] + arr[j] + arr[k]; // Moved inside while
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);

                    ans.add(temp);
                    j++;
                    k--;

                    // skip the duplicate j element.
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    // skip the duplicate k element.
                    while (j < k && arr[k] == arr[k + 1]) { // Changed to while
                        k--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
