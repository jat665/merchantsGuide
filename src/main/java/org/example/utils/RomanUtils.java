package org.example.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanUtils {
    private final Pattern romanPattern = Pattern.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    private final Map<Character, Integer> romanMap = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int toNumber(String romanNumber) {
        // validate roman numeral
        Matcher matcher = romanPattern.matcher(romanNumber);
        if (!matcher.find()) {
            return -1;
        }

        int counter = 0;
        Character lastChar = null;
        int previousValue = -1;
        for (char c : romanNumber.toCharArray()) {
            int value = romanMap.get(c);
            if (lastChar != null) {
                previousValue = romanMap.get(lastChar);
                if (previousValue < value) {
                    counter -= previousValue * 2;
                }
            }
            counter += value;
            lastChar = c;
        }
        return counter;
    }
}
