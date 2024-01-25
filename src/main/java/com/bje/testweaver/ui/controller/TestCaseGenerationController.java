package com.bje.testweaver.ui.controller;

import com.bje.testweaver.core.TestCaseGeneration;
import com.bje.testweaver.ui.bean.TestCaseGenerationBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TestCaseGenerationController {

    private final static TestCaseGeneration generator = new TestCaseGeneration();

    public TestCaseGenerationController(){

    }

    @PostMapping(value = "/generate-test-cases")
    public String generateTestCases(@RequestBody TestCaseGenerationBean testCaseGenerationData)
            throws JsonProcessingException {
        String prompt = "Write a set of comprehensive test cases for the following code snippet using " +
                testCaseGenerationData.getFramework() +
                ". Ensure that your test cases cover a range of input scenarios, including edge cases. Consider both " +
                "normal and boundary inputs to thoroughly assess the code's functionality. Explain the expected output " +
                "for each test case. " +
                "Code snippet: " + testCaseGenerationData.getCode() +
                "Please provide code for the testcases in the mentioned testing framework. Please provide a detailed" +
                "description of your test cases, including any assumptions made. Your goal is to validate the " +
                "correctness and robustness of the code under various conditions.";

        // Remove new line and tab characters
        prompt = prompt.replaceAll("[\\n\\t]+", "");
        return generator.generateTestCases(prompt);
    }
}
