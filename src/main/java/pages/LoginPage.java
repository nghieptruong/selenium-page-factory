package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement txtName;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[normalize-space(.)='Login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]")
    private WebElement lblLoginAlert;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginPageDisplayed() {
        return txtName.isDisplayed() && txtPassword.isDisplayed();
    }

    public void login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLogin();
    }

    public void enterUserName(String userName) {
        sendKeys(txtName, userName);
    }

    public void enterPassword(String password) {
        sendKeys(txtPassword, password);
    }

    public void clickLogin() {
        click(btnLogin);
    }

    public void waitForLoginUrl(String url) {
        waitUrl(url);
    }

    public String getErrorMessage() {
        waitForElementToBeVisible(lblLoginAlert);
        return lblLoginAlert.getText();
    }
}

