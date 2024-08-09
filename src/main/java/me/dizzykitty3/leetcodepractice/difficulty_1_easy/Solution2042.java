package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 2042. Check if Numbers Are Ascending in a Sentence
public class Solution2042 {
    public boolean areNumbersAscending(String s) {
        if (s == null) return true;
        final var subs = s.split("\\s+");
        var list = new ArrayList<Integer>();
        var temp = 0;
        for (var sub : subs) {
            try {
                var number = Integer.parseInt(sub);
                if (temp < number) {
                    temp = number;
                    list.add(number);
                } else return false;
            } catch (NumberFormatException ignore) {
                // ignore
            }
        }
        return true;
    }

    @Test
    void testAreNumbersAscending() {
        assertTrue(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        assertFalse(areNumbersAscending("hello world 5 x 5"));
        assertFalse(areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        assertTrue(areNumbersAscending("1 2 3 4 5"));
        assertTrue(areNumbersAscending("1 2 3 4 5 6"));
        assertFalse(areNumbersAscending("1 2 6 3 4 5 6"));
        assertTrue(areNumbersAscending("1 9"));
    }
}
