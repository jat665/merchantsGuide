package utils;

import static org.junit.Assert.*;

import org.example.utils.RomanUtils;
import org.junit.Before;
import org.junit.Test;

public class RomanUtilsTest {
    RomanUtils romanUtils;

    @Before
    public void setup() {
        romanUtils = new RomanUtils();
    }

    @Test
    public void testToNumber1() {
        int result = romanUtils.toNumber("I");
        assertEquals("'I' should be equal 1", 1, result);
    }
}
