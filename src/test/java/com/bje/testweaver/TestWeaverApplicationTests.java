package com.bje.testweaver;

import com.bje.testweaver.service.TestWeaverService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This class contains unit test cases for the application flows.
 *
 * @author ashishwale
 */
@SpringBootTest
class TestWeaverApplicationTests {

    private static TestWeaverService testWeaverService;

    @BeforeAll
    static void setup() {
        testWeaverService = new TestWeaverService();
    }

    @Test
    void testGetTestCases() {
        String code = "int add(int x, int y) {" +
                "return x + y;" +
                "}";
        String framework = "JUnit5";

        String output = testWeaverService.generateTestCases(code, framework);
        Assertions.assertNotNull(output);
    }

}
