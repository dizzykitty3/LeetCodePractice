package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 69 Sqrt(x)
 */
public class Solution69 {
    public int mySqrt(int x) {
        var max = 46341;
        var min = 0;

        while (min + 1 != max) {
            var mid = (max + min) / 2;
            if (x / mid == mid) return mid;
            if (x / mid > mid) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return min;
    }

    @Test
    void testMySqrt() {
        assertEquals(2, mySqrt(4));
        assertEquals(2, mySqrt(8));
        assertEquals(2, mySqrt(5));
        assertEquals(2, mySqrt(6));
        assertEquals(2, mySqrt(7));
        assertEquals(3, mySqrt(9));
        assertEquals(1, mySqrt(1));
        assertEquals(0, mySqrt(0));
        assertEquals(3, mySqrt(10));
        assertEquals(10, mySqrt(100));
        assertEquals(31, mySqrt(1000));
        assertEquals(46340, mySqrt(Integer.MAX_VALUE));
    }
}
