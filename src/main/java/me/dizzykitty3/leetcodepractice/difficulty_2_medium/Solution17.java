package me.dizzykitty3.leetcodepractice.difficulty_2_medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// 17. Letter Combinations of a Phone Number
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        if (isDigitsInvalid(digits)) return Collections.emptyList();

        // "123" -> "23", "0002" -> "2", ...
        var validDigits = removeInvalidDigits(digits);

        var length = validDigits.length();
        List<String> result = new ArrayList<>(Collections.emptyList());

        if (length == 1) {
            // ["a", "b", "c"]
            result.addAll(Arrays.asList(digitToLetter(validDigits.charAt(0))));
        } else if (length == 2) {
            // ["aa", "ab", "ac", "ba", "bb", "bc", "ca", "cb", "cc"]
            for (int i = 0; i <= length; i++) {
                for (int i1 = 0; i1 <= length; i1++) {
                    result.add(digitToLetter(validDigits.charAt(0))[i] + digitToLetter(validDigits.charAt(1))[i1]);
                }
            }
        } else if (length == 3) {
            for (int i = 0; i < length; i++) {
                for (int i1 = 0; i1 < length; i1++) {
                    for (int i2 = 0; i2 < length; i2++) {
                        result.add(digitToLetter(validDigits.charAt(0))[i] + digitToLetter(validDigits.charAt(1))[i1] + digitToLetter(validDigits.charAt(2))[i2]);
                    }
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                for (int i1 = 0; i1 < length; i1++) {
                    for (int i2 = 0; i2 < length; i2++) {
                        for (int i3 = 0; i3 < length; i3++) {
                            result.add(digitToLetter(validDigits.charAt(0))[i] + digitToLetter(validDigits.charAt(1))[i1] + digitToLetter(validDigits.charAt(2))[i2] + digitToLetter(validDigits.charAt(3))[i3]);
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean isDigitsValid(String digits) {
        return digits.contains("2") || digits.contains("3") || digits.contains("4") || digits.contains("5")
                || digits.contains("6") || digits.contains("7") || digits.contains("8") || digits.contains("9");
    }

    private boolean isDigitsInvalid(String digits) {
        return !isDigitsValid(digits);
    }

    private String removeInvalidDigits(String digits) {
        return digits.replace("0", "").replace("1", "");
    }

    private String[] digitToLetter(char digit) {
        return switch (digit) {
            case '2' -> new String[]{"a", "b", "c"};
            case '3' -> new String[]{"d", "e", "f"};
            case '4' -> new String[]{"g", "h", "i"};
            case '5' -> new String[]{"j", "k", "l"};
            case '6' -> new String[]{"m", "n", "o"};
            case '7' -> new String[]{"p", "q", "r", "s"};
            case '8' -> new String[]{"t", "u", "v"};
            case '9' -> new String[]{"w", "x", "y", "z"};
            default -> new String[]{};
        };
    }

    @Test
    void testIsDigitsValid() {
        assertTrue(isDigitsValid("123"));
        assertTrue(isDigitsValid("012"));
        assertTrue(isDigitsValid("0002"));
        assertTrue(isDigitsValid("1112"));
        assertFalse(isDigitsValid("0101"));
        assertFalse(isDigitsValid("0"));
        assertFalse(isDigitsValid("1"));
        assertFalse(isDigitsValid("1010"));
        assertFalse(isDigitsValid(""));
    }

    @Test
    void testRemoveInvalidDigits() {
        assertEquals("23", removeInvalidDigits("123"));
        assertEquals("2", removeInvalidDigits("012"));
        assertEquals("", removeInvalidDigits("0101"));
    }

    @Test
    void testLetterCombinations() {
        assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), letterCombinations("23"));
        assertEquals(Collections.emptyList(), letterCombinations(""));
        assertEquals(Arrays.asList("a", "b", "c"), letterCombinations("2"));
        assertEquals(Arrays.asList("d", "e", "f"), letterCombinations("3"));
        assertEquals(Arrays.asList("g", "h", "i"), letterCombinations("4"));
        assertEquals(Arrays.asList("j", "k", "l"), letterCombinations("5"));
        assertEquals(Arrays.asList("m", "n", "o"), letterCombinations("6"));
        assertEquals(Arrays.asList("p", "q", "r", "s"), letterCombinations("7"));
        assertEquals(Arrays.asList("t", "u", "v"), letterCombinations("8"));
        assertEquals(Arrays.asList("w", "x", "y", "z"), letterCombinations("9"));
        assertEquals(Collections.emptyList(), letterCombinations("0"));
        assertEquals(Collections.emptyList(), letterCombinations("1"));
        assertEquals(Collections.emptyList(), letterCombinations("01"));
        assertEquals(Collections.emptyList(), letterCombinations("00"));
        assertEquals(Collections.emptyList(), letterCombinations("0000"));
        assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), letterCombinations("123"));
        assertEquals(Arrays.asList("aa", "ab", "ac", "ba", "bb", "bc", "ca", "cb", "cc"), letterCombinations("22"));
        assertEquals(Arrays.asList("aaa", "aab", "aac", "aba", "abb", "abc", "aca", "acb", "acc", "baa", "bab", "bac", "bba", "bbb", "bbc", "bca", "bcb", "bcc", "caa", "cab", "cac", "cba", "cbb", "cbc", "cca", "ccb", "ccc"), letterCombinations("222"));
    }
}