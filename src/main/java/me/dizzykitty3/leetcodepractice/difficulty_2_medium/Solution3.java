package me.dizzykitty3.leetcodepractice.difficulty_2_medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

// TODO Time Limit Exceeded
// 3. Longest Substring Without Repeating Characters
public class Solution3 {
    // Submit result: Time Limit Exceeded
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

    private boolean hasDuplicateChars(String s) {
        if (s == null || s.length() <= 1) return false;

        final HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) return true;
        }
        return false;
    }

    @Test
    void testHasDuplicateChars() {
        assertFalse(hasDuplicateChars(""));
        assertFalse(hasDuplicateChars("a"));
        assertTrue(hasDuplicateChars("aa"));
        assertFalse(hasDuplicateChars("abc"));
        assertFalse(hasDuplicateChars("abcd"));
        assertTrue(hasDuplicateChars("abcdd"));
    }

    @Test
    void testLengthOfLongestSubstring() {
        assertEquals(0, lengthOfLongestSubstring("")); // ""
        assertEquals(1, lengthOfLongestSubstring("aaa")); // "a"
        assertEquals(3, lengthOfLongestSubstring("abcabcbb")); // "abc"
        assertEquals(1, lengthOfLongestSubstring("bbbbb")); // "b"
        assertEquals(3, lengthOfLongestSubstring("pwwkew")); // "wke"
        assertEquals(7, lengthOfLongestSubstring("adbshell")); // "adbshel"
        assertEquals(4, lengthOfLongestSubstring("google")); // "ogle"
        assertEquals(3, lengthOfLongestSubstring("java")); // "jav"
        assertEquals(7, lengthOfLongestSubstring("abcdefg")); // "abcdefg"
    }
}