/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.scxml;

import java.net.URL;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.apache.commons.scxml.model.State;
/**
 * Unit tests {@link org.apache.commons.scxml.SCXMLExecutor}.
 * Testing wildcard event matching (*)
 */
public class WildcardTest extends TestCase {
    /**
     * Construct a new instance of SCXMLExecutorTest with
     * the specified name
     */
    public WildcardTest(String name) {
        super(name);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(WildcardTest.class);
        suite.setName("SCXML Executor Tests, wildcard event match");
        return suite;
    }

    // Test data
    private URL wildcard01;
    private SCXMLExecutor exec;

    /**
     * Set up instance variables required by this test case.
     */
    public void setUp() {
        wildcard01 = this.getClass().getClassLoader().
            getResource("org/apache/commons/scxml/env/jexl/wildcard-01.xml");
    }

    /**
     * Tear down instance variables required by this test case.
     */
    public void tearDown() {
        wildcard01 = null;
    }

    /**
     * Test the SCXML documents, usage of "_eventdata"
     */
    public void testWildcard01Sample() {
    	exec = SCXMLTestHelper.getExecutor(wildcard01);
        assertNotNull(exec);
        try {
            Set currentStates = exec.getCurrentStatus().getStates();
            assertEquals(1, currentStates.size());
            assertEquals("state1", ((State)currentStates.iterator().
                next()).getId());
            currentStates = SCXMLTestHelper.fireEvent(exec, "*");
            assertEquals(1, currentStates.size());
            assertEquals("state4", ((State)currentStates.iterator().
                next()).getId());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    public static void main(String args[]) {
        TestRunner.run(suite());
    }
}