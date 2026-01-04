package SlidingWindow.Strings;

// 424. Longest Repeating Character Replacement
public class Leetcode424 {

    // brute force tc is o(n^2) and sc is o(1).
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        // Try every starting position
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int maxFreq = 0;

            // Try every ending position from i
            for (int j = i; j < n; j++) {
                // Update frequency of current character
                freq[s.charAt(j) - 'A']++;

                // Update max frequency in current substring
                maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

                // Calculate current window length
                int windowLen = j - i + 1;

                // Calculate replacements needed
                int replacements = windowLen - maxFreq;

                // If valid, update maxLen
                if (replacements <= k) {
                    maxLen = Math.max(maxLen, windowLen);
                }
            }
        }

        return maxLen;
    }

    // optimal tc is o(n) and sc is o(1).
    public int characterReplacement2(String s, int k) {
        int l = 0, r = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int[] hash = new int[26];

        while (r < s.length()) {
            // update frequency of current character
            hash[s.charAt(r) - 'A']++;
            // update the maximum frequency of any character in the window
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);

            // check if window is invalid (too many replacements needed)
            while ((r - l + 1) - maxFreq > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }

            // update maxLen with valid window size
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

}
