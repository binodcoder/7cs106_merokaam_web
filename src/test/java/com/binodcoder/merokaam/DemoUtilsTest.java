package com.binodcoder.merokaam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {
      DemoUtils demoUtils;
    @BeforeEach
    public void beforeEachSetUp(){
       demoUtils= new DemoUtils();
    }

    @DisplayName("Same and Not Same")
    @Test
    public void testSameAndNotSame(){
        String str="luv2code";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
        assertNotSame(str, demoUtils.getAcademy(), "Object should not refer to same object");

    }

    @DisplayName("True and False")
    @Test
    public void testTrueAndFalse(){
        int n1=2;
        int n2=1;
        assertTrue(demoUtils.isGreater(n1,n2), "n1 should greater than n2");
        assertFalse(demoUtils.isGreater(n2, n1), "n1 should not greater than n2");
    }
}
