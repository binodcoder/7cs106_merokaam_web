package com.binodcoder.merokaam;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MeroKaamApplicationTest {

    @Test
    void testEqualsAndNotEquals() {
        MerokaamApplication merokaamApplication = new MerokaamApplication();
        assertEquals(6, merokaamApplication.sum(2, 4), "2+4 must be 6");
        assertNotEquals(6, merokaamApplication.sum(1,9), "1+9 must not be 6" );
    }
}
