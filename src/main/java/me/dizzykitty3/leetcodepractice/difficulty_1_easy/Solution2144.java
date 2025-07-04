package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 2144 Minimum Cost of Buying Candies With Discount
 * <li>Array</li>
 * <li>Greedy</li>
 * <li>Sorting</li>
 */
public class Solution2144 {
    public int minimumCost(int[] cost) {
        if (cost == null || cost.length == 0) return 0;

        final var length = cost.length;

        var list = new ArrayList<Integer>();
        for (int i : cost) {
            list.add(i);
        }
        Collections.sort(list); // ASC

        var result = 0;
        for (var i = length - 1; i >= 0; i--) {
            if ((length - i) % 3 != 0) {
                result += list.get(i);
            }
        }
        return result;
    }

    @Test
    void testMinimumCost() {
        assertEquals(5, minimumCost(new int[]{1, 2, 3}));
        assertEquals(23, minimumCost(new int[]{6, 5, 7, 9, 2, 2}));
        assertEquals(10, minimumCost(new int[]{5, 5}));
        assertEquals(0, minimumCost(new int[]{}));
        assertEquals(0, minimumCost(new int[]{0}));
        assertEquals(3, minimumCost(new int[]{1, 2}));
        assertEquals(8, minimumCost(new int[]{1, 2, 3, 4}));
        assertEquals(12, minimumCost(new int[]{1, 2, 3, 4, 5}));
        assertEquals(16, minimumCost(new int[]{1, 2, 3, 4, 5, 6}));
    }
}