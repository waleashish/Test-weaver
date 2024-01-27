package com.bje.testweaver.service;

import com.bje.testweaver.core.TestCaseGeneration;

/**
 * This class exposes all the service APIs to external users.
 *
 * @author ashishwale
 */
public class TestWeaverService {

    private final TestCaseGeneration testCaseGeneration;

    public TestWeaverService() {
        this.testCaseGeneration = new TestCaseGeneration();
    }

    /**
     * This api returns the generated test cases for the input.
     *
     * @param code
     *      the code snippet
     * @param framework
     *      the framework in which test cases are to be generated
     * @return
     *      string output of the generated test cases and their explanation
     */
    public String generateTestCases(String code, String framework) {
        return testCaseGeneration.generateTestCases(code, framework);
    }
}
