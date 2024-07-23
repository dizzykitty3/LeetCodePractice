package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 1550. Three Consecutive Odds
public class Solution1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr == null || arr.length <= 2) return false;
        if (arr.length == 3) return isOddNumber(arr[0]) && isOddNumber(arr[1]) && isOddNumber(arr[2]);

        final int length = arr.length;
        for (int i = 0; i + 2 < length; i++) {
            final boolean r3 = isOddNumber(arr[i + 2]);
            if (!r3) {
                i += 2;
                continue;
            }
            final boolean r2 = isOddNumber(arr[i + 1]);
            if (!r2) {
                i += 1;
                continue;
            }
            final boolean r1 = isOddNumber(arr[i]);
            if (r1) return true;
        }
        return false;
    }

    private boolean isOddNumber(int num) {
        return Math.abs(num) % 2 == 1;
    }

    @Test
    void testThreeConsecutiveOdds() {
        assertFalse(threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        assertTrue(threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12})); // 5, 7, 23
        assertFalse(threeConsecutiveOdds(new int[]{}));
        assertFalse(threeConsecutiveOdds(new int[]{1}));
        assertTrue(threeConsecutiveOdds(new int[]{1, 3, 5}));
        assertFalse(threeConsecutiveOdds(new int[]{1, 3, 4, 4, 5}));
        assertTrue(threeConsecutiveOdds(new int[]{1, 3, 7}));
        assertFalse(threeConsecutiveOdds(new int[]{-1}));
        assertTrue(threeConsecutiveOdds(new int[]{-1, -3, -5}));
        assertFalse(threeConsecutiveOdds(new int[]{-1, -3, -6}));
        assertFalse(threeConsecutiveOdds(new int[]{1, 3, -4, 4, 5}));
        assertFalse(threeConsecutiveOdds(new int[]{1, 3, 4, -4, 5}));
        assertTrue(threeConsecutiveOdds(new int[]{1, 3, -5}));
        assertFalse(threeConsecutiveOdds(new int[]{0, 0, 0, 0, 0, 0, 0}));
        assertTrue(threeConsecutiveOdds(new int[]{1, 1, 1, 1, 1}));
    }
}
