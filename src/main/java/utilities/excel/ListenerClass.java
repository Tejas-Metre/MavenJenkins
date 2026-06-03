/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.aventstack.extentreports.Status
 *  org.testng.ITestContext
 *  org.testng.ITestListener
 *  org.testng.ITestResult
 */
package utilities.excel;

import com.aventstack.extentreports.Status;

import actiondriver.ActionDriverElement;


import utilities.excel.ExtentManager;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass
extends ExtentManager
implements ITestListener {
   // WebDriverAction act = new WebDriverAction();
	ActionDriverElement act= new ActionDriverElement();
	 
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
        System.out.println("on test start");
    }

    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == 1) {
            test.log(Status.PASS, "Pass Test case is: " + result.getName());
            System.out.println("In pass testcase");
        }
    }

    public void onTestFailure(ITestResult result) {
//        if (result.getStatus() == 2) {
//            try {
                test.log(Status.FAIL, "Fail Test case is: " + result.getName());
//                String path = ActionDriverElement.getScreenShot(result.getName());
//                test.fail("screenshort " + test.addScreenCaptureFromPath(path));
                System.out.println("In fail testcase");
         //   }
           // catch (IOException e) {
               // e.printStackTrace();
           // }
       // }
    }

    public void onTestSkipped(ITestResult result) {
       // result.getStatus();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }
}

