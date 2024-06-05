package me.dizzykitty3.leetcodepractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{3, 3}, 6));
        assertArrayEquals(new int[]{-1, -1}, solution.twoSum(new int[]{3, 4}, 6));
        assertArrayEquals(new int[]{2, 3}, solution.twoSum(new int[]{1, 2, 3, 4}, 7));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(solution.isPalindrome(121));
        assertFalse(solution.isPalindrome(-121));
        assertFalse(solution.isPalindrome(10));
        assertTrue(solution.isPalindrome(12321));
        assertTrue(solution.isPalindrome(969));
        assertFalse(solution.isPalindrome(123));
        assertFalse(solution.isPalindrome(12334));
        assertFalse(solution.isPalindrome(331));
        assertTrue(solution.isPalindrome(666));
        assertTrue(solution.isPalindrome(0));
        assertTrue(solution.isPalindrome(123454321));
        assertFalse(solution.isPalindrome(1234543210));
    }

    @Test
    void testRomanToInt() {
        assertEquals(solution.romanToInt("III"), 3);
        assertEquals(solution.romanToInt("LVIII"), 58);
        assertEquals(solution.romanToInt("MCMXCIV"), 1994);
        assertEquals(solution.romanToInt("I"), 1);
        assertEquals(solution.romanToInt("VI"), 6);
        assertEquals(solution.romanToInt("XIII"), 13);
    }

    @Test
    void testLongestCommonPrefix() {
        assertEquals(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}), "fl");
        assertEquals(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}), "");
        assertEquals(solution.longestCommonPrefix(new String[]{"dog", "door", "do"}), "do");
    }

    @Test
    void testIsValidParentheses() {
        assertTrue(solution.isValidParentheses("()"));
        assertTrue(solution.isValidParentheses("()[]{}"));
        assertFalse(solution.isValidParentheses("(]"));
        assertTrue(solution.isValidParentheses("[]"));
        assertTrue(solution.isValidParentheses("{}"));
        assertTrue(solution.isValidParentheses("{[()]}"));
        assertFalse(solution.isValidParentheses("{[(()]}"));
    }

    @Test
    void testHasDuplicateChars() {
        assertFalse(solution.hasDuplicateChars(""));
        assertFalse(solution.hasDuplicateChars("a"));
        assertTrue(solution.hasDuplicateChars("aa"));
        assertFalse(solution.hasDuplicateChars("abc"));
        assertFalse(solution.hasDuplicateChars("abcd"));
        assertTrue(solution.hasDuplicateChars("abcdd"));
    }

    @Test
    void testLengthOfLongestSubstring() {
        assertEquals(solution.lengthOfLongestSubstring(""), 0); // ""
        assertEquals(solution.lengthOfLongestSubstring("aaa"), 1); // "a"
        assertEquals(solution.lengthOfLongestSubstring("abcabcbb"), 3); // "abc"
        assertEquals(solution.lengthOfLongestSubstring("bbbbb"), 1); // "b"
        assertEquals(solution.lengthOfLongestSubstring("pwwkew"), 3); // "wke"
        assertEquals(solution.lengthOfLongestSubstring("adbshell"), 7); // "adbshel"
        assertEquals(solution.lengthOfLongestSubstring("google"), 4); // "ogle"
        assertEquals(solution.lengthOfLongestSubstring("java"), 3); // "jav"
        assertEquals(solution.lengthOfLongestSubstring("abcdefg"), 7); // "abcdefg"
    }
}
