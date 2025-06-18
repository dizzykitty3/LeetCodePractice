package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 3110. Score of a String
public class Solution3110 {
    public int scoreOfString(String s) {
        if ("".equals(s)) return 0;
        final var length = s.length();
        if (length == 1) return 0;

        final char[] chars = s.toCharArray();
        final var values = new ArrayList<Integer>();
        for (char ch : chars) {
            values.add((int) ch);
        }

        var result = 0;
        for (var i = 0; i < (length - 1); i++) {
            final var gap = Math.abs(values.get(i + 1) - values.get(i));
            result += gap;
        }
        return result;
    }

    @Test
    void testScoreOfString() {
        assertEquals(13, scoreOfString("hello"));
        assertEquals(50, scoreOfString("zaz"));
        assertEquals(0, scoreOfString(""));
    }
}