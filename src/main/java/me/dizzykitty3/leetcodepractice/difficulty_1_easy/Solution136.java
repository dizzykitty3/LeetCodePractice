package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 136 Single Number
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        var set = new HashSet<>(Collections.emptySet());
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        var temp = set.toArray();
        return (int) temp[0];
    }

    @Test
    void testSingleNumber() {
        assertEquals(1, singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));
        assertEquals(1, singleNumber(new int[]{1}));
        assertEquals(33, singleNumber(new int[]{11, 22, 11, 22, 33}));
        assertEquals(3, singleNumber(new int[]{0, 0, 3, 1, 1}));
        assertEquals(Integer.MAX_VALUE, singleNumber(new int[]{0, 0, Integer.MAX_VALUE, 1, 1}));
        assertEquals(Integer.MAX_VALUE, singleNumber(new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, Integer.MAX_VALUE}));
    }
}