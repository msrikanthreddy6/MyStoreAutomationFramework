package com.mystore.qa.util;


import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

import java.io.IOException;

public class CustomAssertion extends Assertion {

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {

        try {
            TestUtil.takeScreenshotIfExceptionOccurred();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
