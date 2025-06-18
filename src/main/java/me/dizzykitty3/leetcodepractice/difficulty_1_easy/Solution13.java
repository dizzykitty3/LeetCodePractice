package me.dizzykitty3.leetcodepractice.difficulty_1_easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 13 Roman to Integer
 * <li>Hash Table</li>
 * <li>Math</li>
 * <li>String</li>
 */
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
        assertEquals(3, romanToInt("III"));
        assertEquals(58, romanToInt("LVIII"));
        assertEquals(1994, romanToInt("MCMXCIV"));
        assertEquals(1, romanToInt("I"));
        assertEquals(6, romanToInt("VI"));
        assertEquals(13, romanToInt("XIII"));
    }
}