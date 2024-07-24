package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 28. Find the Index of the First Occurrence in a String
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
        assertEquals(strStr("sadbutsad", "sad"), 0);
        assertEquals(strStr("leetcode", "leeto"), -1);
        assertEquals(strStr("leetcode", "leetcode"), 0);
        assertEquals(strStr("a", "ab"), -1);
        assertEquals(strStr("acadab", "ab"), 4);
        assertEquals(strStr("123", "123"), 0);
        assertEquals(strStr("456123", "123"), 3);
    }
}
