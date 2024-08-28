package com.binodcoder.merokaam;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
// @DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
// @DisplayNameGeneration(DisplayNameGenerator.Simple.class)
public class MeroKaamApplicationTest {

    MerokaamApplication merokaamApplication;

    @BeforeEach
    void setUpBeforeEach() {
        merokaamApplication = new MerokaamApplication();
        System.out.println("@BeforeEach executes before the execution of each");
    }

    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Running @AfterEach");
        System.out.println();
    }

    @BeforeAll
    static void setUpBeforeEachClass() {
        System.out.println("@BeforeAll executes only once before all test methods execution in the class");
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("@AfterAll executes only once after all test methods execution in the class");
    }

    @Test
    @DisplayName("Equals and Not Equals")
    void testEqualsAndNotEquals() {
        System.out.println("Running test: testEqualsAndNotEquals");
        assertEquals(6, merokaamApplication.sum(2, 4), "2+4 must be 6");
        assertNotEquals(6, merokaamApplication.sum(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and Not Null")
    void testNullAndNotNull() {
        System.out.println("Running test: testNullAndNotNull");
        String str1 = null;
        String str2 = "binodcoder";
        assertNull(merokaamApplication.checkNull(str1), "Object should be null");
        assertNotNull(merokaamApplication.checkNull(str2), "Object should not be null");
    }
}
