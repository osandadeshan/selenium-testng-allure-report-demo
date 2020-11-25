package util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static util.driver.DriverHolder.getDriver;

public class AllureReportListener implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG (WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog (String message) {
        return message;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Starting Test Suite '" + iTestContext.getName() + "'.......");
        iTestContext.setAttribute("WebDriver", getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Finished Test Suite '" + iTestContext.getName() + "'");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Starting Test Method '" + getTestMethodName(iTestResult) + "'");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test Method '" + getTestMethodName(iTestResult) + "' is Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test Method '" + getTestMethodName(iTestResult) + "' is Failed");
        WebDriver driver = getDriver();
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot has captured for the Test Method '" + getTestMethodName(iTestResult) + "'");
            saveScreenshotPNG(driver);
        }
        saveTextLog("Test Method '" + getTestMethodName(iTestResult) + "' is failed and screenshot taken");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Method '" + getTestMethodName(iTestResult) + "' is Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
}
