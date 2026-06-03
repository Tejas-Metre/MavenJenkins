/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.aventstack.extentreports.ExtentReporter
 *  com.aventstack.extentreports.ExtentReports
 *  com.aventstack.extentreports.ExtentTest
 *  com.aventstack.extentreports.reporter.ExtentHtmlReporter
 *  com.aventstack.extentreports.reporter.configuration.Theme
 */
package utilities.excel;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent() {
        System.out.println("in set extent before file set");
        htmlReporter = new ExtentHtmlReporter(String.valueOf(System.getProperty("user.dir")) + "\\src\\test\\resources\\Report\\" + "MyReport.html");
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        System.out.println("in set extent after file set");
        extent = new ExtentReports();
        extent.attachReporter(new ExtentReporter[]{htmlReporter});
        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "TDD Framework");
        extent.setSystemInfo("Tester", "Richa");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "FireFox");
    }

    public static void endReport() {
        extent.flush();
    }
}

