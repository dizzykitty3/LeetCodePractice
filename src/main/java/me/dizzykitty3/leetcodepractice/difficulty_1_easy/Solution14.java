package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 14. Longest Common Prefix
// Easy
// #String #Trie
public class Solution14 {
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

    @Test
    void testLongestCommonPrefix() {
        assertEquals(longestCommonPrefix(new String[]{"flower", "flow", "flight"}), "fl");
        assertEquals(longestCommonPrefix(new String[]{"dog", "racecar", "car"}), "");
        assertEquals(longestCommonPrefix(new String[]{"dog", "door", "do"}), "do");
    }
}
