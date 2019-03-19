// =============================================================================
// Copyright 2006-2013 Daniel W. Dyer
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// =============================================================================
package cn.vincent.automation.testSample;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import cn.vincent.automation.lib.ReporterLogger;

/**
 * Some successful tests to be included in the sample output.
 * 
 * @author Daniel Dyer
 */
@Test(groups = "should-pass")
public class SuccessfulTests {
    private ReporterLogger LOGGER = new ReporterLogger(SuccessfulTests.class);

    @Test
    public void test1() {
        assert true;
    }

    @Test(description = "This is a test description")
    public void testWithDescription1() {
        assert true;
    }

    @Test
    public void testWithOutput1() {
        LOGGER.info("Here is some output from a successful test.");
        assert true;
    }

    @Test
    public void testWithMultiLineOutput1() {
        LOGGER.info("This is the first line of 3.");
        LOGGER.info("This is a second line.");
        LOGGER.info("This is the third.");
        assert true;
    }

    @AfterMethod
    public void afterMethod() {
        // This is here to detect any problems processing config
        // methods.
    }

    @AfterClass
    public void afterClass() {
        // This is here to detect any problems processing config
        // methods.
    }

    @AfterSuite
    public void afterSuite() {
        // This is here to detect any problems processing config
        // methods.
    }
}
