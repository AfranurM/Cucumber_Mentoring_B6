package StepDefinition;

import Day3_POM.LoginPageElements;
import Day3_Utils.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class Day3_LumaLoginFunctionalityTest {

    LoginPageElements loginPageElements = new LoginPageElements();

    @Given("User navigates to Luma website")
    public void user_navigates_to_luma_website() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @Given("User click to sign in button")
    public void user_click_to_sign_in_button() {
        loginPageElements.findAndClick("signInButton");
    }
    @Given("User fill email input as {string}")
    public void user_fill_email_input_as(String email) {
        loginPageElements.findAndSend("emailInput", email);
    }
    @Given("User fill password input as {string}")
    public void user_fill_password_input_as(String password) {
        loginPageElements.findAndSend("passwordInput", password);
    }
    @Given("User click sign in button")
    public void user_click_sign_in_button() {
        loginPageElements.findAndClick("signInButtonConfirm");
    }
    @Then("User should be successfully signed in")
    public void user_should_be_successfully_signed_in() {
        loginPageElements.findAndContainsText("welcomeText", "welcome,");
        Driver.quitDriver();

    }
}
