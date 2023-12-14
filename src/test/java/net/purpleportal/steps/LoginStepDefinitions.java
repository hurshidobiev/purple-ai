package net.purpleportal.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.purpleportal.pages.LoginPage;
import net.purpleportal.utils.BrowserUtils;
import net.purpleportal.utils.ConfigReader;
import net.purpleportal.utils.Driver;
import org.junit.Assert;

public class LoginStepDefinitions {
LoginPage loginPage = new LoginPage();
    @Given("admin user is on the login page")
    public void admin_user_is_on_the_login_page() {
       Driver.get().get(ConfigReader.get("url"));
    }

    @Then("sign-in logo is displayed")
    public void signInLogoIsDisplayed(){
        BrowserUtils.waitForVisibility(loginPage.signInLogo, 6000);
        Assert.assertTrue(loginPage.signInLogo.isDisplayed());
    }
    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password){
      loginPage.login(username, password);
    }

    @Then("the user should see {string}")
    public void the_user_should_see(String expected){

        Assert.assertTrue(loginPage.actualTitle(expected).contains(expected));
    }


}
