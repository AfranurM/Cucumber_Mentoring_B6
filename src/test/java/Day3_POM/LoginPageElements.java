package Day3_POM;

import Day3_Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements extends BasePOM {

    public LoginPageElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Sign In")
    private WebElement signInButton;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(id = "send2")
    private WebElement signInButtonConfirm;

    @FindBy(xpath = "(//span[contains(text(),'Welcome')])[1]")
    private WebElement welcomeText;

    WebElement myElement;

    public void findAndClick(String strElement) {
        switch (strElement) {
            case "signInButton":
                myElement = signInButton;
                break;
            case "signInButtonConfirm":
                myElement = signInButtonConfirm;
                break;
        }
        clickFunction(myElement);
    }

    public void findAndSend(String strElement, String value) {

        switch (strElement) {
            case "emailInput":
                myElement = emailInput;
                break;
            case "passwordInput":
                myElement = passwordInput;
                break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndContainsText(String strElement, String text) {

        switch (strElement) {
            case "welcomeText":
                myElement = welcomeText;
                break;
        }
        verifyContainsText(myElement, text);

    }
}
