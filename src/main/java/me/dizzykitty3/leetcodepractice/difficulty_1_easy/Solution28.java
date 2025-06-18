package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 28 Find the Index of the First Occurrence in a String
 * <li>Two Pointers</li>
 * <li>String</li>
 * <li>String Matching</li>
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if ("".equals(haystack) || "".equals(needle)) return -1;
        if (!haystack.contains(needle)) return -1;

        final var needleLength = needle.length();
        final var haystackLength = haystack.length();
        if (needleLength > haystackLength) return -1;

        final var gap = haystackLength - needleLength;
        for (var i = 0; i <= gap; i++) {
            final var temp = haystack.substring(i, i + needleLength);
            if (temp.equals(needle)) return i;
        }
        return -1; // no cases
    }

    @Test
    void testStrStr() {
        assertEquals(0, strStr("sadbutsad", "sad"));
        assertEquals(-1, strStr("leetcode", "leeto"));
        assertEquals(0, strStr("leetcode", "leetcode"));
        assertEquals(-1, strStr("a", "ab"));
        assertEquals(4, strStr("acadab", "ab"));
        assertEquals(0, strStr("123", "123"));
        assertEquals(3, strStr("456123", "123"));
    }
}