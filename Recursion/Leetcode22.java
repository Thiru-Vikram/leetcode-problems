package Recursion;

import java.util.*;

// Complete Guide: Time Complexity for Recursion Problems

// THE MASTER FORMULA
// TC = (Number of Recursive Calls)^(Depth) × (Work per Call)
// TC = branches^depth × work

// STEP-BY-STEP PROCESS
// Step 1: Count BRANCHES
// "How many recursive calls are made PER function call?"
// Pattern A: Both IFs Execute → Multiple Branches
// if(condition1) {
//     recurse();  // Call 1
// }
// if(condition2) {
//     recurse();  // Call 2
// }
// // Both can run → branches = 2
// Pattern B: IF-ELSE → Only 1 Branch
// if(condition) {
//     recurse();  // Call 1
// } else {
//     recurse();  // Call 2
// }
// // Only ONE runs → branches = 1
// Pattern C: Loop → Many Branches
// for(int i = 0; i < n; i++) {
//     recurse();
// }
// // branches = n (or whatever loop runs)

// Step 2: Find DEPTH
// "How many levels until base case?"
// Pattern A: Decreasing by 1
// f(n-1)  →  Depth = n
// Pattern B: Dividing by 2
// f(n/2)  →  Depth = log n
// Pattern C: Increasing by 1 until limit
// f(index+1) where index goes 0 → n  →  Depth = n
// Pattern D: Building string/array
// java// If building length 2n
// Depth = 2n

// Step 3: Calculate WORK per Call
// "What do I do BESIDES recursing?"
// Look for work anywhere in the function:
// O(1) Work - Just Operations
// int x = a + b;        // O(1)
// if(n == 0) return;    // O(1)
// return fib(n-1) + fib(n-2);  // Addition is O(1)
// O(n) Work - String Concatenation
// str + "("             // O(length of str) = O(n)
// O(n) Work - Array/List Copy
// new ArrayList<>(current)     // O(size of current) = O(n)
// Arrays.copyOf(arr, n)        // O(n)
// O(n) Work - Loop
// for(int i = 0; i < n; i++) {
//     // do something
// }
// // O(n) work
// O(n) Work - Merge Operation
// merge(arr, left, mid, right)  // Merging n elements = O(n)

public class Leetcode22 {

    // tc is o(2 ^ 2n * n) so o(4 ^ n * n).
    // sc is o(n).
    private void generate(ArrayList<String> ans, int n, int open, int close, String str) {
        if (str.length() == (2 * n)) {
            ans.add(str);
            return;
        }
        // first always start from open parenthesis.
        // here we check with n from 0 to n u allowed add (.
        if (open < n) {
            generate(ans, n, open + 1, close, str + "(");
        }
        // after ( also add ) so that both open == close.
        if (close < open) {
            generate(ans, n, open, close + 1, str + ")");
        }
    }

    public List<String> generateParenthesis(int n) {

        ArrayList<String> ans = new ArrayList<>();
        generate(ans, n, 0, 0, "");

        return ans;
    }

    public static void main(String[] args) {

    }
}