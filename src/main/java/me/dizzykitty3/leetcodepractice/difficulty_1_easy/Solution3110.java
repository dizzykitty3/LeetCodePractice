package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 3110. Score of a String
// Easy
// #String
public class Solution3110 {
    public int scoreOfString(String s) {
        if ("".equals(s)) return 0;
        final int length = s.length();
        if (length == 1) return 0;

        final char[] chars = s.toCharArray();
        final List<Integer> values = new ArrayList<>();
        for (char ch : chars) {
            values.add((int) ch);
        }

        int result = 0;
        for (int i = 0; i < (length - 1); i++) {
            final int gap = Math.abs(values.get(i + 1) - values.get(i));
            result += gap;
        }
        return result;
    }

    @Test
    void testScoreOfString() {
        assertEquals(scoreOfString("hello"), 13);
        assertEquals(scoreOfString("zaz"), 50);
        assertEquals(scoreOfString(""), 0);
    }
}
