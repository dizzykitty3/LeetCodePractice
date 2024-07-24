package me.dizzykitty3.leetcodepractice.difficulty_2_medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 7. Reverse Integer
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
        assertEquals(reverse(0), 0);
        assertEquals(reverse(1), 1);
        assertEquals(reverse(-1), -1);
        assertEquals(reverse(123), 321);
        assertEquals(reverse(-123), -321);
        assertEquals(reverse(120), 21);
        assertEquals(reverse(1_200), 21);
        assertEquals(reverse(-1_200), -21);
        assertEquals(reverse(-123_456), -654_321);
        assertEquals(reverse(1_534_236_469), 0);
        assertEquals(reverse(-1_534_236_469), 0);
        assertEquals(reverse(-1_234_567_899), 0);
        assertEquals(reverse(-2_147_483_412), -2_143_847_412);
        assertEquals(reverse(-2_147_483_648), 0); // MIN_VALUE
    }
}
