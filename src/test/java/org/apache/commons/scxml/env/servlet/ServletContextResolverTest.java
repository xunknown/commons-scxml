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
package org.apache.commons.scxml.env.servlet;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ServletContextResolverTest extends TestCase {

    public ServletContextResolverTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(ServletContextResolverTest.class);
    }

    public static void main(String args[]) {
        String[] testCaseName = {ServletContextResolverTest.class.getName()};
        junit.textui.TestRunner.main(testCaseName);
    }

    public void testIllegalInstance() {
    	try {
            new ServletContextResolver(null);
            fail("ServletContextResolver successfully instantiated with"
                + " null ServletContext");
    	} catch (IllegalArgumentException iae) {
    		// expected, ignore
    	}
    }

}