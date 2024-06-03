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
    }

    @Test
    void testRomanToInt() {
        assertEquals(solution.romanToInt("III"), 3);
        assertEquals(solution.romanToInt("LVIII"), 58);
        assertEquals(solution.romanToInt("MCMXCIV"), 1994);
    }

    @Test
    void testLongestCommonPrefix() {
        assertEquals(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}), "fl");
        assertEquals(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}), "");
    }

    @Test
    void testIsValid() {
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("()[]{}"));
        assertFalse(solution.isValid("(]"));
    }
}
