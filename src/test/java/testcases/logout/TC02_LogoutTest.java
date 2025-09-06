package testcases.logout;

import base.BaseTest;
import drivers.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import reports.ExtentReportManager;

public class TC02_LogoutTest extends BaseTest {

    @Test
    public void TC02_Verify_Logout_Test() {

        LoginPage loginPage = new LoginPage(DriverManager.getCurrentDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getCurrentDriver());

//        ExtentReportManager.info("Start TC02_Verify_Logout_Test");

        final String username = "Admin";
        final String password = "admin123";

        //Step 1: Go to https://opensource-demo.orangehrmlive.com
        logger.info("Step 1: Go to https://opensource-demo.orangehrmlive.com");
//        ExtentReportManager.info("Step 1: Go to https://opensource-demo.orangehrmlive.com");
        DriverManager.getCurrentDriver().get("https://opensource-demo.orangehrmlive.com");

        //Step 2: Enter username
        //Step 3: Enter password
        //Step 4: Click "Login" button
        logger.info("Step 2: Enter username");
        logger.info("Step 3: Enter password");
        logger.info("Step 4: Click 'Login' button");
//        ExtentReportManager.info("Step 2: Enter username");
//        ExtentReportManager.info("Step 3: Enter password");
//        ExtentReportManager.info("Step 4: Click 'Login' button");

        loginPage.login(username, password);

        //Step 5: Click Acount dropdown on the top right
        //Step 6: Click "Logout" link
        logger.info("Step 5: Click Acount dropdown on the top right");
        logger.info("Step 6: Click 'Logout' link");
//        ExtentReportManager.info("Step 5: Click Acount dropdown on the top right");
//        ExtentReportManager.info("Step 6: Click 'Logout' link");

        dashboardPage.logOut();

        //Step 7: Verify that the user logged out successfully
        //VP: Login page displays
        logger.info("Step 7: Verify that the user logged out successfully");
        logger.info("VP: Login page displays");
//        ExtentReportManager.info("Step 7: Verify that the user logged out successfully");
//        ExtentReportManager.info("VP: Login page displays");
        loginPage.waitForLoginUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Assert.assertEquals(DriverManager.getCurrentDriver().getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        ExtentReportManager.pass("PASSED");
    }
}
