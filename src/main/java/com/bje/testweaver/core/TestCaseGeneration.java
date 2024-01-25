package com.bje.testweaver.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import jep.JepConfig;
import jep.MainInterpreter;
import jep.SharedInterpreter;
import jep.python.PyObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

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

    public String generateTestCases(String prompt) throws JsonProcessingException {
        // Create shared interpreter object to call our python script
        String outputString = "";
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
