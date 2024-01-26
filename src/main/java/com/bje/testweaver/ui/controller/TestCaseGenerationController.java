package com.bje.testweaver.ui.controller;

import com.bje.testweaver.core.TestCaseGeneration;
import com.bje.testweaver.ui.bean.TestCaseGenerationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is REST controller containing apis to communicate with UI.
 */
@CrossOrigin
@RestController
public class TestCaseGenerationController {

    private final static TestCaseGeneration generator = new TestCaseGeneration();

    public TestCaseGenerationController() {
    }

    /**
     * This api returns the generated test cases for the input.
     *
     * @param testCaseGenerationData
     *      test case generation data bean
     * @return
     *      string output of generated test cases and their explanation
     */
    @PostMapping(value = "/generate-test-cases")
    public String generateTestCases(@RequestBody TestCaseGenerationBean testCaseGenerationData) {
        return generator.generateTestCases(testCaseGenerationData.getCode(), testCaseGenerationData.getFramework());
    }
}
