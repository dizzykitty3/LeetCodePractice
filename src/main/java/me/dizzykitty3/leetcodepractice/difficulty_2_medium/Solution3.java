package me.dizzykitty3.leetcodepractice.difficulty_2_medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 3 Longest Substring Without Repeating Characters
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (Objects.isNull(s) || Objects.equals(s, "")) return 0;
        var length = s.length();
        if (length == 1) return 1;

        for (var i = length; i >= 1; i--) {
            for (var i1 = 0; i1 + i <= length; i1++) {
                var subString = s.substring(i1, i1 + i);
                if (!hasDuplicateChars(subString)) {
                    return i;
                }
            }
        }
        return 1;
    }

    private boolean hasDuplicateChars(String s) {
        if (s == null || s.length() <= 1) return false;
        var set = new HashSet<>();
        for (var c : s.toCharArray()) {
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
        assertEquals(1, lengthOfLongestSubstring("a")); // "a"
        assertEquals(1, lengthOfLongestSubstring("aa")); // "a"
        assertEquals(1, lengthOfLongestSubstring("aaaa")); // "a"
        assertEquals(1, lengthOfLongestSubstring("aaa")); // "a"
        assertEquals(3, lengthOfLongestSubstring("abcabcbb")); // "abc"
        assertEquals(1, lengthOfLongestSubstring("bbbbb")); // "b"
        assertEquals(3, lengthOfLongestSubstring("pwwkew")); // "wke"
        assertEquals(7, lengthOfLongestSubstring("adbshell")); // "adbshel"
        assertEquals(4, lengthOfLongestSubstring("google")); // "ogle"
        assertEquals(3, lengthOfLongestSubstring("java")); // "jav"
        assertEquals(7, lengthOfLongestSubstring("abcdefg")); // "abcdefg"
        assertEquals(26, lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyz")); // "abcdefghijklmnopqrstuvwxyz"
        assertEquals(26, lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz")); // "abcdefghijklmnopqrstuvwxyz"
        assertEquals(26, lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy")); // "abcdefghijklmnopqrstuvwxyz"
    }
}