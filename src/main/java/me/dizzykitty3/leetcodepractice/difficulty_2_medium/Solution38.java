package me.dizzykitty3.leetcodepractice.difficulty_2_medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// 38. Count and Say
public class Solution38 {
    public String countAndSay(int n) {
        var result = "1";
        for (var i = 1; i < n; i++) {
            result = runLengthEncoding(result);
        }
        return result;
    }

    private String runLengthEncoding(String s) {
        if ("".equals(s)) return "invalid input";
        final var length = s.length();
        if (isRepeating(s)) return length + s.substring(0, 1);

        final var indexes = splitIndexes(s);
        final var builder = new StringBuilder();
        var start = 0;
        for (var index : indexes) {
            final var temp = s.substring(start, index + 1);
            builder.append(temp.length());
            builder.append(temp.charAt(0));
            start = index + 1;
        }
        final var lastSubstring = s.substring(start, length);
        builder.append(lastSubstring.length());
        builder.append(lastSubstring.charAt(0));
        return builder.toString();
    }

    private boolean isRepeating(String s) {
        if ("".equals(s)) return false;
        final var length = s.length();
        final char ch = s.charAt(0);
        for (var i = 0; i < length; i++) {
            if (s.charAt(i) != ch) return false;
        }
        return true;
    }

    private List<Integer> splitIndexes(String s) {
        final char[] chars = s.toCharArray();
        final var indexes = new ArrayList<Integer>();
        for (var i = 0; i < chars.length - 1; i++) {
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
        assertEquals("11", runLengthEncoding("1"));
        assertEquals("12", runLengthEncoding("2"));
        assertEquals("13", runLengthEncoding("3"));
        assertEquals("21", runLengthEncoding("11"));
        assertEquals("81", runLengthEncoding("11111111"));
        assertEquals("8112", runLengthEncoding("111111112"));
        assertEquals("1211", runLengthEncoding("21"));
        assertEquals("2211", runLengthEncoding("221"));
        assertEquals("3311", runLengthEncoding("3331"));
        assertEquals("111221", runLengthEncoding("1211"));
        assertEquals("22", runLengthEncoding("22"));
        assertEquals("23", runLengthEncoding("33"));
        assertEquals("33", runLengthEncoding("333"));
        assertEquals("313233", runLengthEncoding("111222333"));
        assertEquals("312211", runLengthEncoding("111221"));
    }

    @Test
    void testCountAndSay() {
        assertEquals("1", countAndSay(1));
        assertEquals("11", countAndSay(2));
        assertEquals("21", countAndSay(3));
        assertEquals("1211", countAndSay(4));
        assertEquals("111221", countAndSay(5));
        assertEquals("312211", countAndSay(6));
        assertEquals("13112221", countAndSay(7));
        assertEquals("1113213211", countAndSay(8));
    }
}