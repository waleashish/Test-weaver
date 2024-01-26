package com.bje.testweaver.core;

import jep.JepConfig;
import jep.MainInterpreter;
import jep.SharedInterpreter;
import jep.python.PyObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * This class contains methods to generate test cases using Jep library.
 *
 * @author ashishwale
 */
public class TestCaseGeneration {
    public TestCaseGeneration() {
        String pythonFolder = System.getenv("DYLD_LIBRARY_PATH");
        //define the JEP library path
        String jepPath = pythonFolder + "/libjep.jnilib";
        if (!Files.exists(Path.of(jepPath))){
            jepPath = pythonFolder + "/libjep.so";
        }
        //initialize the MainInterpreter
        MainInterpreter.setJepLibraryPath(jepPath);
        // Set JEP config
        jep.JepConfig jepConf = new JepConfig();
        jepConf.addIncludePaths("/Users/ashishwale/Documents/ASU/projects/test-weaver/src/main/resources/python");
        jepConf.addIncludePaths(pythonFolder);
        SharedInterpreter.setConfig(jepConf);
    }

    /**
     * This method generates test cases for the given code and framework input.
     *
     * @param code
     *      the code snippet
     * @param framework
     *      the framework in which test cases are to be generated
     * @return
     *      string output of the generated test cases and their explanation
     */
    public String generateTestCases(String code, String framework) {
        String prompt = "Write a set of comprehensive test cases for the following code snippet using " +
                framework +
                ". Ensure that your test cases cover a range of input scenarios, including edge cases. Consider both " +
                "normal and boundary inputs to thoroughly assess the code's functionality. Explain the expected output " +
                "for each test case. " +
                "Code snippet: " + code +
                "Please provide code for the testcases in the mentioned testing framework. Please provide a detailed" +
                "description of your test cases, including any assumptions made. Your goal is to validate the " +
                "correctness and robustness of the code under various conditions.";
        return generatePromptOutput(removeCharacters(prompt));
    }

    /**
     * Removes new line and tab character from the given string.
     *
     * @param prompt
     *      the string
     * @return
     *      modified string
     */
    private String removeCharacters(String prompt) {
        return prompt.replaceAll("[\\n\\t]+", "");
    }

    /**
     * The method generates LLM output for the given prompt.
     *
     * @param prompt
     *      the prompt
     * @return
     *      String output for the prompt
     */
    private String generatePromptOutput(String prompt) {
        // Create shared interpreter object to call our python script
        String outputString;
        try(SharedInterpreter sharedInterpreter = new SharedInterpreter();) {
            sharedInterpreter.eval("import python_script as p");
            sharedInterpreter.eval("output = p.generate_test_cases(\"" + prompt + "\")");
            // Get the output of the evaluation in a PyObject object
            PyObject object = (PyObject)sharedInterpreter.getValue("output");
            // The "generations" attribute is guaranteed to have ArrayList of String objects with a size of one.
            // Get the output of the cohere api
            outputString = ((ArrayList<String>)object.getAttr("generations")).get(0);
        }
        return outputString;
    }

}
