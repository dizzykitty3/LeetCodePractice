package me.dizzykitty3.leetcodepractice;

import java.util.HashSet;
import java.util.Objects;
import java.util.Stack;

public class Solution {
    /**
     * 1. Two Sum
     * <p>
     * [Easy] #Array #HashTable
     */
    public int[] twoSum(int[] nums, int target) {
        final int length = nums.length;

        for (int i = 0; i < length; i++) {
            final int gap = target - nums[i]; // avoid doing extensive addition operations
            for (int j = i + 1; j < length; j++) { // j starts with i + 1
                if (nums[j] == gap) return new int[]{i, j}; // return the answer
            }
        }
        return new int[]{-1, -1}; // return [-1, -1] if there is no answer
    }

    /**
     * 3. Longest Substring Without Repeating Characters
     * <p>
     * [Medium] #HashTable #String #SlidingWindow
     */
    public int lengthOfLongestSubstring(String s) {
        if (Objects.isNull(s) || Objects.equals(s, "")) return 0;
        final int length = s.length();
        if (length == 1) return 1;

        int result = 1; // starts with 1
        for (int i = 2; i <= length; i++) {
            for (int i1 = 0; i1 + i <= length; i1++) {
                final String subString = s.substring(i1, i1 + i);
                final boolean isValid = hasDuplicateChars(subString);
                if (!isValid) {
                    result = i;
                    break; // don't need to check other substring with the same length
                }
            }
        }
        return result;
    }

    protected boolean hasDuplicateChars(String s) {
        if (s == null || s.length() <= 1) return false;

        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) return true;
        }
        return false;
    }

    /**
     * 9. Palindrome Number
     * <p>
     * [Easy] #Math
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;

        int temp = x;
        int reversed = 0;

        while (temp > 9) {
            reversed = (reversed + (temp % 10)) * 10;
            temp = temp / 10;
        }
        reversed += temp;
        return reversed == x;
    }

    /**
     * 13. Roman to Integer
     * <p>
     * [Easy] #HashTable #Math #String
     */
    public int romanToInt(String s) {
        final int length = s.length();
        int result = 0;
        int currentValue;
        int nextValue;

        for (int i = 0; i < length; i++) {
            currentValue = toInt(s.charAt(i));
            if (i + 1 >= length) nextValue = 0;
            else nextValue = toInt(s.charAt(i + 1));

            if (currentValue < nextValue) {
                result += (nextValue - currentValue);
                i++;
            } else {
                result += currentValue;
            }
        }
        return result;
    }

    private static int toInt(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1_000;
            default -> 0;
        };
    }

    /**
     * 14. Longest Common Prefix
     * <p>
     * [Easy] #String #Trie
     */
    public String longestCommonPrefix(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        final int mLongestLength = longestLength(strs);
        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < mLongestLength; i++) {
            char temp = 0;
            for (int i1 = 0; i1 < strs.length; i1++) {
                if (strs[i1].length() <= i) return builder.toString();

                if (0 == i1) {
                    temp = strs[i1].charAt(i);
                } else {
                    if (temp != strs[i1].charAt(i)) return builder.toString();
                }
            }
            builder.append(temp);
        }
        return builder.toString();
    }

    private static int longestLength(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) return 0;
        if (strs.length == 1) return strs[0].length();

        int longestLength = 0;

        for (String str : strs) {
            final int currentLength = str.length();
            if (currentLength > longestLength) longestLength = currentLength;
        }
        return longestLength;
    }

    /**
     * 20. Valid Parentheses
     * <p>
     * [Easy] #String #Stack
     */
    public boolean isValidParentheses(String s) {
        if (Objects.isNull(s) || s.length() % 2 != 0) return false;

        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char currentChar = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(currentChar);
            } else {
                final Character topChar = stack.peek();
                if ((currentChar == ')' && Objects.equals(topChar, '('))
                        || (currentChar == ']' && Objects.equals(topChar, '['))
                        || (currentChar == '}' && Objects.equals(topChar, '{'))) {
                    stack.pop();
                } else {
                    stack.push(currentChar);
                }
            }
        }
        return stack.isEmpty();
    }
}
