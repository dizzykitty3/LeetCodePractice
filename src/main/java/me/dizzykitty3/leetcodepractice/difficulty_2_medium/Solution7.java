package me.dizzykitty3.leetcodepractice.difficulty_2_medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO submit answer
// 7. Reverse Integer
// Medium
//
public class Solution7 {
    public int reverse(int x) {
        if (x == 0) return 0;

        boolean isMinus = false;
        if (x < 0) {
            isMinus = true;
            x = Math.abs(x);
        }

        int temp = x;
        int reversed = 0;

        while (temp > 9) {
            reversed = (reversed + (temp % 10)) * 10;
            temp = temp / 10;
        }
        reversed += temp;

        if (isMinus) return -reversed;
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
    }
}
