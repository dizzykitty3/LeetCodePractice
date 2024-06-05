package me.dizzykitty3.leetcodepractice;

import java.util.*;

public class Solution {
    /**
     * 1. Two Sum
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
                    result++;
                    break; // don't need to check other substring with the same length
                }
            }
        }
        return result;
    }

    protected boolean hasDuplicateChars(String s) {
        if (s == null || s.length() <= 1) return false;

        final HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) return true;
        }
        return false;
    }

    /**
     * 4. Median of Two Sorted Arrays
     * [Hard]
     */
    @SuppressWarnings("unused")
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int length1 = nums1.length;
        final int length2 = nums2.length;
        if (length1 == 0) return findMedianSortedArray(nums2);
        if (length2 == 0) return findMedianSortedArray(nums1);
        if (length1 == 1 && length2 == 1) return (nums1[0] + nums2[0]) * 0.5D;

        final int totalLength = length1 + length2;
        final boolean isOdd = isOddNumber(totalLength);
        final int resultIndex = totalLength / 2 + 1;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length1; i++) {
            // TODO
        }
        return 0D; // TODO
    }

    protected boolean isOddNumber(int num) {
        return Math.abs(num) % 2 == 1;
    }

    private double findMedianSortedArray(int[] nums) {
        final int length = nums.length;
        if (length == 0) return 0D;
        if (length == 1) return nums[0];
        final int resultIndex = length / 2 + 1;
        return isOddNumber(length) ? nums[resultIndex] : (nums[resultIndex - 1] + nums[resultIndex]) * 0.5D;
    }

    /**
     * 9. Palindrome Number
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

    /**
     * 28. Find the Index of the First Occurrence in a String
     * [Easy] #TwoPointers #String #StringMatching
     */
    public int strStr(String haystack, String needle) {
        if ("".equals(haystack) || "".equals(needle)) return -1;
        if (!haystack.contains(needle)) return -1;

        final int needleLength = needle.length();
        final int haystackLength = haystack.length();
        if (needleLength > haystackLength) return -1;

        final int gap = haystackLength - needleLength;
        for (int i = 0; i <= gap; i++) {
            final String temp = haystack.substring(i, i + needleLength);
            if (temp.equals(needle)) return i;
        }
        return -1; // no cases
    }

    /**
     * 35. Search Insert Position
     * [Easy] #Array #BinarySearch
     */
    public int searchInsert(int[] nums, int target) {
        final int length = nums.length;
        if (length == 0) return 0;

        for (int i = 0; i < length; i++) {
            final int num = nums[i];
            if (target > num && i == length - 1) {
                return length;
            } else if (target == num) {
                return i;
            } else if (target < num) {
                return i;
            }
        }
        return -1; // no cases maybe
    }

    /**
     * 58. Length of Last Word
     * [Easy] #String
     */
    public int lengthOfLastWord(String s) {
        if ("".equals(s)) return 0;

        final String trimmedString = s.trim();
        if (!trimmedString.contains(" ")) return trimmedString.length();

        final int lastIndex = trimmedString.lastIndexOf(" ");
        final String lastWord = trimmedString.substring(lastIndex + 1);
        return lastWord.length();
    }
}
