package me.dizzykitty3.leetcodepractice.difficulty_2_medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 7 Reverse Integer
 * <li>Math</li>
 */
public class Solution7 {
    public int reverse(int x) {
        // Note: x = Math.abs(x) when x < 0 overflows if x = Integer.MIN_VALUE,
        // since Integer.MIN_VALUE == -2_147_483_648, and Integer.MAX_VALUE == 2_147_483_647.

        var reversed = 0;

        while (x != 0) {
            final var nextDigit = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && nextDigit > 7)) return 0; // overflow
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && nextDigit < -8)) return 0; // overflow
            reversed = reversed * 10 + nextDigit;
        }
        return reversed;
    }

    @Test
    void testReverse() {
        assertEquals(0, reverse(0));
        assertEquals(1, reverse(1));
        assertEquals(-1, reverse(-1));
        assertEquals(321, reverse(123));
        assertEquals(-321, reverse(-123));
        assertEquals(21, reverse(120));
        assertEquals(21, reverse(1_200));
        assertEquals(-21, reverse(-1_200));
        assertEquals(-654_321, reverse(-123_456));
        assertEquals(0, reverse(1_534_236_469));
        assertEquals(0, reverse(-1_534_236_469));
        assertEquals(0, reverse(-1_234_567_899));
        assertEquals(-2_143_847_412, reverse(-2_147_483_412));
        assertEquals(0, reverse(-2_147_483_648)); // MIN_VALUE
    }
}