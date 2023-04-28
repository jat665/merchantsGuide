package org.example.utils;

import java.util.HashMap;
import java.util.Map;

public class RomanUtils {

    Map<Character, Integer> romanMap = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int toNumber(String roman) {
        if (!romanMap.containsKey(roman.charAt(0))) {
            return -1;
        }
        return romanMap.get(roman.charAt(0));
    }
}
