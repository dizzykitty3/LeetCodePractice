package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// 66. Plus One
public class Solution66 {
    public int[] plusOne(int[] digits) {
        var length = digits.length;
        int[] result;

        if (isDigitsAllNines(digits)) {
            // 9 -> 10, 99 -> 100, 999 -> 1000, ...
            // needs a new digit
            result = new int[length + 1];
            result[0] = 1;
            for (int i = 1; i < length + 1; i++) {
                result[i] = 0;
            }
        } else {
            // 89 -> 90, 199 -> 200, 191 -> 192, 1099 -> 1100, ...
            result = new int[length];
            var needPlusOne = true;
            for (int i = length - 1; i >= 0; i--) {
                if (digits[i] == 9 && needPlusOne) {
                    result[i] = 0;
                } else if (needPlusOne) {
                    needPlusOne = false;
                    result[i] = digits[i] + 1;
                } else {
                    result[i] = digits[i];
                }
            }
        }
        return result;
    }

    private boolean isDigitsAllNines(int[] digits) {
        for (int digit : digits) {
            if (digit != 9) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testIsDigitsAllNines() {
        assertTrue(isDigitsAllNines(new int[]{9}));
        assertTrue(isDigitsAllNines(new int[]{9, 9}));
        assertTrue(isDigitsAllNines(new int[]{9, 9, 9}));
        assertTrue(isDigitsAllNines(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}));
        assertFalse(isDigitsAllNines(new int[]{8, 9}));
        assertFalse(isDigitsAllNines(new int[]{0}));
        assertFalse(isDigitsAllNines(new int[]{7, 9, 9}));
        assertFalse(isDigitsAllNines(new int[]{7, 9, 9, 9}));
    }

    @Test
    void testPlusOne() {
        assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{4, 3, 2, 2}, plusOne(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
        assertArrayEquals(new int[]{1, 0, 0}, plusOne(new int[]{9, 9}));
        assertArrayEquals(new int[]{1}, plusOne(new int[]{0}));
        assertArrayEquals(new int[]{9, 0}, plusOne(new int[]{8, 9}));
        assertArrayEquals(new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 8}, plusOne(new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 7}));
        assertArrayEquals(new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 9}, plusOne(new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 8}));
        assertArrayEquals(new int[]{2, 1, 4, 7, 4, 8, 3, 6, 5, 0}, plusOne(new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 9}));
        assertArrayEquals(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, plusOne(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}));
        assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1}, plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
    }
}