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
        assertEquals("should be equal to 1", 1, result);
    }

    @Test
    public void testToNumber5() {
        int result = romanUtils.toNumber("V");
        assertEquals("should be equal to 5", 5, result);
    }

    @Test
    public void testToNumber10() {
        int result = romanUtils.toNumber("X");
        assertEquals("should be equal to 10", 10, result);
    }

    @Test
    public void testToNumber50() {
        int result = romanUtils.toNumber("L");
        assertEquals("should be equal to 50", 50, result);
    }

    @Test
    public void testToNumber100() {
        int result = romanUtils.toNumber("C");
        assertEquals("should be equal to 100", 100, result);
    }

    @Test
    public void testToNumber500() {
        int result = romanUtils.toNumber("D");
        assertEquals("should be equal to 500", 500, result);
    }

    @Test
    public void testToNumber1000() {
        int result = romanUtils.toNumber("M");
        assertEquals("should be equal to 1000", 1000, result);
    }

    @Test
    public void testToInvalidNumber1() {
        int result = romanUtils.toNumber("Z");
        assertEquals("should be equal to -1", -1, result);
    }

    @Test
    public void testToInvalidNumber2() {
        int result = romanUtils.toNumber("IIII");
        assertEquals("should be equal to -1", -1, result);
    }

    @Test
    public void testToInvalidNumber3() {
        int result = romanUtils.toNumber("XXXX");
        assertEquals("should be equal to -1", -1, result);
    }

    @Test
    public void testToInvalidNumber4() {
        int result = romanUtils.toNumber("ID");
        assertEquals("should be equal to -1", -1, result);
    }

    @Test
    public void testToInvalidNumber5() {
        int result = romanUtils.toNumber("IC");
        assertEquals("should be equal to -1", -1, result);
    }

    @Test
    public void testValidNumber() {
        int result = romanUtils.toNumber("XXXIX");
        assertTrue("should be different to -1", result != -1);
    }
}
