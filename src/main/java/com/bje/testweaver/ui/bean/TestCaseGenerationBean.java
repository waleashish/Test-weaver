package com.bje.testweaver.ui.bean;

/**
 * This bean holds the code snippet and framework data coming from UI.
 *
 * @author ashishwale
 */
public class TestCaseGenerationBean {
    /**
     * The code input coming from UI.
     */
    private String code;
    /**
     * The framework input coming from UI
     */
    private String framework;

    /**
     * Returns the code snippet.
     *
     * @return
     *      code snippet in string format
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code snippet.
     *
     * @param code
     *      the code snippet value
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns the framework.
     *
     * @return
     *      framework name
     */
    public String getFramework() {
        return framework;
    }

    /**
     * Sets the framework name.
     *
     * @param framework
     *      the framework name to set
     */
    public void setFramework(String framework) {
        this.framework = framework;
    }
}
