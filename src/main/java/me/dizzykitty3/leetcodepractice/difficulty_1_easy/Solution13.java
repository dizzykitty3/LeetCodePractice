package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 13. Roman to Integer
public class Solution13 {
    public int romanToInt(String s) {
        final var length = s.length();
        var result = 0;
        int currentValue;
        int nextValue;

        for (var i = 0; i < length; i++) {
            currentValue = toInt(s.charAt(i));
            if (i + 1 >= length) nextValue = 0;
            else nextValue = toInt(s.charAt(i + 1));

            if (currentValue < nextValue) {
                result += (nextValue - currentValue);
                i++;
            } else {
                result += currentValue;
            }
        }
        return result;
    }

    private static int toInt(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1_000;
            default -> 0;
        };
    }

    @Test
    void testRomanToInt() {
        assertEquals(romanToInt("III"), 3);
        assertEquals(romanToInt("LVIII"), 58);
        assertEquals(romanToInt("MCMXCIV"), 1994);
        assertEquals(romanToInt("I"), 1);
        assertEquals(romanToInt("VI"), 6);
        assertEquals(romanToInt("XIII"), 13);
    }
}
