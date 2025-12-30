package Arrays;

// 344. Reverse String
public class Leetcode344 {

    // optimal
    // tc is o(n) and sc is o(1).
    public void reverseString(char[] s) {

        int n = s.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    public void swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }

    public static void main(String[] args) {

    }
}