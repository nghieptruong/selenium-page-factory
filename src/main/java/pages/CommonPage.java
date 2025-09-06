package pages;

import components.TopBarNavigation;
import org.openqa.selenium.WebDriver;


public class CommonPage extends BasePage {

    private TopBarNavigation topBarNavigation;

    public CommonPage(WebDriver driver) {
        super(driver);
        this.topBarNavigation = new TopBarNavigation(driver);
    }

    public String getTopBarTitle() {
        return topBarNavigation.getTopBarTitle();
    }

    public void logOut() {
        topBarNavigation.logOut();
    }
}
