package net.purpleportal.pages;

import net.purpleportal.utils.BrowserUtils;
import net.purpleportal.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy (xpath = "//div[@class = 'signin-logo']")
    public WebElement signInLogo;

    @FindBy (id = "username")
    public WebElement usernameBox;

    @FindBy (id = "password")
    public WebElement passwordBox;

    @FindBy (id = "login")
    public WebElement signIn;

    @FindBy (xpath = "//div[@class = 'alert alert-failure alert-error']")
    public WebElement loginErrorMessage;

    public void login (String username, String password){
        BrowserUtils.waitForVisibility(usernameBox, 6000);
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        signIn.click();
    }

    public String actualTitle(String expected){
        String actualTitle;

        if (expected.equals("Purple")){

            actualTitle = Driver.get().getTitle();
        }else{
            BrowserUtils.waitForVisibility(loginErrorMessage, 6000);
            actualTitle = loginErrorMessage.getText();
        }return actualTitle;
    }

}