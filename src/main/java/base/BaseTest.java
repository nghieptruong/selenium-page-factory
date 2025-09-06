package base;

import drivers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import reports.ExtentReportManager;
import utils.ConfigManager;

import java.lang.reflect.Method;


public class BaseTest {

    protected final Logger logger = LogManager.getLogger(getClass());

    @BeforeSuite
    public void beforeSuite() {
        logger.info("Starting Test Suite");
        ExtentReportManager.initializeExtentReports();
        ConfigManager.loadProperties();
    }

    @BeforeMethod
    public void setUp(Method method) {
        logger.info("Setting up test");
        ExtentReportManager.createTest(method.getName());
        String browser = ConfigManager.getProperty("browser","chrome");
        DriverManager.getDriver(browser);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        WebDriver driver = DriverManager.getCurrentDriver();
        if (driver != null) {
            if (result.getStatus() == ITestResult.FAILURE) {
                ExtentReportManager.captureScreenshot(driver, result.getMethod().getMethodName());
            }
            DriverManager.quitDriver();
        }
        logger.info("Test completed");
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReportManager.flushReports();
        logger.info("Test Suite completed");
    }
}
