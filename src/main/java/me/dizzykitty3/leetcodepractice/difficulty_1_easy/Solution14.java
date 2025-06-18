package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 14 Longest Common Prefix
 * <li>String</li>
 * <li>Trie</li>
 */
public class Solution14 {
    private static int longestLength(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) return 0;
        if (strs.length == 1) return strs[0].length();

        var longestLength = 0;

        for (var str : strs) {
            final var currentLength = str.length();
            if (currentLength > longestLength) longestLength = currentLength;
        }
        return longestLength;
    }

    public String longestCommonPrefix(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) return "";
        final var length = strs.length;
        if (length == 1) return strs[0];

        final var mLongestLength = longestLength(strs);
        final var builder = new StringBuilder();

        for (var i = 0; i < mLongestLength; i++) {
            char temp = 0;
            for (var i1 = 0; i1 < length; i1++) {
                if (strs[i1].length() <= i) return builder.toString();

                if (0 == i1) {
                    // append the character into the result string
                    temp = strs[i1].charAt(i);
                } else {
                    // compare and return
                    if (temp != strs[i1].charAt(i)) return builder.toString();
                }
            }
            builder.append(temp);
        }
        return builder.toString();
    }

    @Test
    void testLongestCommonPrefix() {
        assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        assertEquals("do", longestCommonPrefix(new String[]{"dog", "door", "do"}));
    }
}