/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.scxml.env;

import java.net.URL;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Unit tests {@link org.apache.commons.scxml.env.AbstractStateMachine}.
 */
public class AbstractStateMachineTest extends TestCase {

    /**
     * Construct a new instance of AbstractStateMachineTest with the specified name
     */
    public AbstractStateMachineTest(String name) {
        super(name);
    }

    // Test data
    private boolean fooCalled;
    private boolean barCalled;

    /**
     * Set up instance variables required by this test case.
     */
    public void setUp() {
        fooCalled = false;
        barCalled = false;
    }

    public void testMoreThanOneScxmlDocument() throws Exception {
        URL fooScxmlDocument = getClass().getResource("foo.xml");
        URL barScxmlDocument = getClass().getResource("bar.xml");

        new Foo(fooScxmlDocument);
        new Bar(barScxmlDocument);

        assertTrue(fooCalled);
        assertTrue(barCalled);
    }

    private class Foo extends AbstractStateMachine {

        public Foo(final URL scxmlDocument) {
            super(scxmlDocument);
        }

        public void foo() {
            fooCalled = true;
        }
    }

    private class Bar extends AbstractStateMachine {

        public Bar(final URL scxmlDocument) {
            super(scxmlDocument);
        }

        public void bar() {
            barCalled = true;
        }
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(AbstractStateMachineTest.class);
        suite.setName("AbstractStateMachine Tests");
        return suite;
    }

    public static void main(String args[]) {
        TestRunner.run(suite());
    }
}