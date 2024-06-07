package me.dizzykitty3.leetcodepractice.difficulty_2_medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// 38. Count and Say
// Medium
// #String
public class Solution38 {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = runLengthEncoding(result);
        }
        return result;
    }

    private String runLengthEncoding(String s) {
        if ("".equals(s)) return "invalid input";
        final int length = s.length();
        if (isRepeating(s)) return length + s.substring(0, 1);

        final List<Integer> indexes = splitIndexes(s);
        final StringBuilder builder = new StringBuilder();
        int start = 0;
        for (Integer index : indexes) {
            final String temp = s.substring(start, index + 1);
            builder.append(temp.length());
            builder.append(temp.charAt(0));
            start = index + 1;
        }
        final String lastSubstring = s.substring(start, length);
        builder.append(lastSubstring.length());
        builder.append(lastSubstring.charAt(0));
        return builder.toString();
    }

    private boolean isRepeating(String s) {
        if ("".equals(s)) return false;
        final int length = s.length();
        final char ch = s.charAt(0);
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != ch) return false;
        }
        return true;
    }

    private List<Integer> splitIndexes(String s) {
        final char[] chars = s.toCharArray();
        final List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1]) indexes.add(i);
        }
        return indexes;
    }

    @Test
    void testIsRepeating() {
        assertTrue(isRepeating("1"));
        assertTrue(isRepeating("111"));
        assertTrue(isRepeating("1111111"));
        assertFalse(isRepeating(""));
        assertFalse(isRepeating("12"));
        assertFalse(isRepeating("11111111111112"));
        assertFalse(isRepeating("211111111111112"));
        assertFalse(isRepeating("211111555111111112"));
        assertFalse(isRepeating("111111112"));
    }

    @Test
    void testSplitIndexes() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        assertEquals(splitIndexes("12"), list1);
        assertEquals(splitIndexes("21"), list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        assertEquals(splitIndexes("112"), list2);
        assertEquals(splitIndexes("221"), list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(1);
        assertEquals(splitIndexes("123"), list3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(0);
        list4.add(1);
        assertEquals(splitIndexes("1211"), list4);
        List<Integer> list5 = new ArrayList<>();
        list5.add(7);
        assertEquals(splitIndexes("111111112"), list5);
    }

    @Test
    void testRunLengthEncoding() {
        assertEquals(runLengthEncoding("1"), "11");
        assertEquals(runLengthEncoding("2"), "12");
        assertEquals(runLengthEncoding("3"), "13");
        assertEquals(runLengthEncoding("11"), "21");
        assertEquals(runLengthEncoding("11111111"), "81");
        assertEquals(runLengthEncoding("111111112"), "8112");
        assertEquals(runLengthEncoding("21"), "1211");
        assertEquals(runLengthEncoding("221"), "2211");
        assertEquals(runLengthEncoding("3331"), "3311");
        assertEquals(runLengthEncoding("1211"), "111221");
        assertEquals(runLengthEncoding("22"), "22");
        assertEquals(runLengthEncoding("33"), "23");
        assertEquals(runLengthEncoding("333"), "33");
        assertEquals(runLengthEncoding("111222333"), "313233");
        assertEquals(runLengthEncoding("111221"), "312211");
    }

    @Test
    void testCountAndSay() {
        assertEquals(countAndSay(1), "1");
        assertEquals(countAndSay(2), "11");
        assertEquals(countAndSay(3), "21");
        assertEquals(countAndSay(4), "1211");
        assertEquals(countAndSay(5), "111221");
        assertEquals(countAndSay(6), "312211");
        assertEquals(countAndSay(7), "13112221");
        assertEquals(countAndSay(8), "1113213211");
    }
}
