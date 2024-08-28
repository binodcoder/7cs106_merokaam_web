package com.binodcoder.merokaam;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MeroKaamApplicationTest {

    @Test
    void testEqualsAndNotEquals() {
        MerokaamApplication merokaamApplication = new MerokaamApplication();
        assertEquals(6, merokaamApplication.sum(2, 4), "2+4 must be 6");
        assertNotEquals(6, merokaamApplication.sum(1,9), "1+9 must not be 6" );
    }

    @Test
    void testNullAndNotNull(){
        MerokaamApplication merokaamApplication=new MerokaamApplication();
        String str1=null;
        String str2="binodcoder";

        assertNull( merokaamApplication.checkNull(str1), "Object should be null");
        assertNotNull(merokaamApplication.checkNull(str2), "Object should not be null");
    }
}
