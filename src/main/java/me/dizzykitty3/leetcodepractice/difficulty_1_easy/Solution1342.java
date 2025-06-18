package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1342 Number of Steps to Reduce a Number to Zero
 * <li>Math</li>
 * <li>Bit Manipulation</li>
 */
public class Solution1342 {
    public int numberOfSteps(int num) {
        if (num < 0) return -1;

        var step = 0;
        while (num != 0) {
            num = process(num);
            step += 1;
        }
        return step;
    }

    private int process(int num) {
        if (isOddNumber(num)) return subtractOne(num);
        return divideByTwo(num);
    }

    private boolean isOddNumber(int num) {
        return Math.abs(num) % 2 == 1;
    }

    private int divideByTwo(int num) {
        return num / 2;
    }

    private int subtractOne(int num) {
        return num - 1;
    }

    @Test
    void testNumberOfSteps() {
        assertEquals(6, numberOfSteps(14));
        assertEquals(4, numberOfSteps(8));
        assertEquals(12, numberOfSteps(123));
        assertEquals(0, numberOfSteps(0));
        assertEquals(1, numberOfSteps(1));
    }
}