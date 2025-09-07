package testcases.login;

import base.BaseTest;
import drivers.DriverManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import reports.ExtentReportManager;

public class TC01_LoginTest extends BaseTest {

    @Test
    public void TC01_Verify_Valid_Login() {

        LoginPage loginPage = new LoginPage(DriverManager.getCurrentDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getCurrentDriver());

        ExtentReportManager.info("Start TC01_Verify_Valid_Login");

        final String username = "Admin";
        final String password = "admin123";

        //Step 1: Go to https://opensource-demo.orangehrmlive.com
        logger.info("Step 1: Go to https://opensource-demo.orangehrmlive.com");
        ExtentReportManager.info("Step 1: Go to https://opensource-demo.orangehrmlive.com");
        DriverManager.getCurrentDriver().get("https://opensource-demo.orangehrmlive.com");

        //Step 2: Enter username
        //Step 3: Enter password
        //Step 4: Click "Login" button
        logger.info("Step 2: Enter username");
        logger.info("Step 3: Enter password");
        logger.info("Step 4: Click 'Login' button");
        ExtentReportManager.info("Step 2: Enter username");
        ExtentReportManager.info("Step 3: Enter password");
        ExtentReportManager.info("Step 4: Click 'Login' button");

        loginPage.login(username, password);

        //Step 5: Verify that the user logged in successfully
        logger.info("Step 5: Verify that the user logged in successfully");
        //VP: Dashboard page displays
        logger.info("VP: Dashboard page displays");
        ExtentReportManager.info("Step 5: Verify that the user logged in successfully");
        ExtentReportManager.info("VP: Dashboard page displays");

        dashboardPage.waitForDashboardUrl("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        Assert.assertEquals(DriverManager.getCurrentDriver().getCurrentUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
                "Dashboard URL");
        Assert.assertTrue(dashboardPage.isPageDisplayed(), "Dashboard page does not display");

        ExtentReportManager.pass("PASSED");
    }

    @Test
    public void TC02_Verify_InValid_Login() {

        LoginPage loginPage = new LoginPage(DriverManager.getCurrentDriver());

        ExtentReportManager.info("Start TC02_Verify_InValid_Login");

        final String username = "Invalid";
        final String password = "Invalid";

        //Step 1: Go to https://opensource-demo.orangehrmlive.com
        logger.info("Step 1: Go to https://opensource-demo.orangehrmlive.com");
        ExtentReportManager.info("Step 1: Go to https://opensource-demo.orangehrmlive.com");
        DriverManager.getCurrentDriver().get("https://opensource-demo.orangehrmlive.com");

        //Step 2: Enter invalid username
        //Step 3: Enter invalid password
        //Step 4: Click "Login" button
        logger.info("Step 2: Enter invalid username");
        logger.info("Step 3: Enter invalid password");
        logger.info("Step 4: Click 'Login' button");
        ExtentReportManager.info("Step 2: Enter invalid username");
        ExtentReportManager.info("Step 3: Enter invalid password");
        ExtentReportManager.info("Step 4: Click 'Login' button");

        loginPage.login(username, password);

        //Step 5: Verify that the user logged in failed
        logger.info("Step 5: Verify that the user logged in failed");
        //VP: 'Invalid credentials' error message displays
        logger.info("VP: 'Invalid credentials' error message displays");
        ExtentReportManager.info("Step 5: Verify that the user logged in failed");
        ExtentReportManager.info("VP: 'Invalid credentials' error message displays");

        //VP: Login page still remains
        logger.info("VP: Login page still remains");
        ExtentReportManager.info("VP: Login page still remains");
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login Page displays"); // get error StaleElementReferenceException, need to call findElement again by wait visibility in isLoginPageDisplayed

        ExtentReportManager.pass("PASSED");
    }
}
