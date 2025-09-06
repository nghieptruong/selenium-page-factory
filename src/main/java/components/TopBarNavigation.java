package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class TopBarNavigation extends BasePage {

    @FindBy(xpath = "//div[@class='oxd-topbar-header-title']")
    private WebElement lblTopBarTitle;

    @FindBy(xpath = "//li[@class='oxd-userdropdown']//img")
    private WebElement imgAccount;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement lnkLogout;

    public TopBarNavigation(WebDriver driver) {
        super(driver);
    }

    public String getTopBarTitle() {
        return getText(lblTopBarTitle);
    }

    public void logOut() {
        clickAccountImg();
        clickLogout();
    }

    public void clickAccountImg() {
        click(imgAccount);
    }

    public void clickLogout() {
       click(lnkLogout);
    }
}
