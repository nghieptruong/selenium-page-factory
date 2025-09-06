package pages;

import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonPage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageDisplayed() {
        return getTopBarTitle().equals("Dashboard");
    }

    public void waitForDashboardUrl(String url) {
        waitUrl(url);
    }
}
