package StepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Day2_WebAppSecurityFunctionalitiesTest {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User navigate to Web App Security")
    public void user_navigate_to_web_app_security() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/index.html");

    }
    @Given("User login to Web App Security")
    public void user_login_to_web_app_security() {

        wait = new WebDriverWait(driver, 10);

        WebElement signInButton = driver.findElement(By.id("signin_button"));
        signInButton.click();
        wait.until(ExpectedConditions.urlContains("login"));

        WebElement usernameInput = driver.findElement(By.id("user_login"));
        usernameInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys("password");

        WebElement signInButtonConfirm = driver.findElement(By.cssSelector("input[value='Sign in']"));
        signInButtonConfirm.click();

        driver.navigate().back();
        wait.until(ExpectedConditions.urlToBe("http://zero.webappsecurity.com/index.html"));

    }
    @When("User navigates to Add New Payee Section")
    public void user_navigates_to_add_new_payee_section() {

        wait = new WebDriverWait(driver, 10);

        WebElement onlineBankingButton = driver.findElement(By.cssSelector("#onlineBankingMenu>div>strong"));
        onlineBankingButton.click();
        wait.until(ExpectedConditions.urlContains("online-banking"));

        WebElement payBillsButton = driver.findElement(By.id("pay_bills_link"));
        payBillsButton.click();
        wait.until(ExpectedConditions.urlContains("pay-bills"));

        WebElement addNewPayeeButton = driver.findElement(By.linkText("Add New Payee"));
        addNewPayeeButton.click();

    }
    @When("User enter {string} and enter {string} and enter {string} and enter {string}")
    public void user_enter_and_enter_and_enter_and_enter(String payeeName, String payeeAddress, String account, String payeeDetails) {

        WebElement payeeNameInput = driver.findElement(By.id("np_new_payee_name"));
        payeeNameInput.sendKeys(payeeName);

        WebElement payeeAddressInput = driver.findElement(By.id("np_new_payee_address"));
        payeeAddressInput.sendKeys(payeeAddress);

        WebElement accountInput = driver.findElement(By.id("np_new_payee_account"));
        accountInput.sendKeys(account);

        WebElement payeeDetailsInput = driver.findElement(By.id("np_new_payee_details"));
        payeeDetailsInput.sendKeys(payeeDetails);

        WebElement addButton = driver.findElement(By.id("add_new_payee"));
        addButton.click();

    }
    @Then("Result should be {string}")
    public void result_should_be(String result) {

        if(result.equals("successful")){
            WebElement successMessage = driver.findElement(By.id("alert_content"));
            Assert.assertTrue(successMessage.isDisplayed());

            WebElement makePaymentsMessage = driver.findElement(By.className("board-header"));
            Assert.assertTrue(makePaymentsMessage.isDisplayed());

        }else if(result.equals("unsuccessful")){
            WebElement makePaymentsMessage = driver.findElement(By.className("board-header"));
            Assert.assertFalse(makePaymentsMessage.isDisplayed());
        }

        driver.quit();
    }

    @When("User navigates to Purchase Foreign Currency Section")
    public void user_navigates_to_purchase_foreign_currency_section() {

        wait = new WebDriverWait(driver, 10);

        WebElement onlineBankingButton = driver.findElement(By.cssSelector("#onlineBankingMenu>div>strong"));
        onlineBankingButton.click();
        wait.until(ExpectedConditions.urlContains("online-banking"));

        WebElement payBillsButton =driver.findElement(By.id("pay_bills_link"));
        payBillsButton.click();
        wait.until(ExpectedConditions.urlContains("pay-bills"));

        WebElement purchaseForeignCurrency = driver.findElement(By.linkText("Purchase Foreign Currency"));
        purchaseForeignCurrency.click();

    }
    @When("User select {string} and select {string} and select USD radio button")
    public void user_select_and_select_and_select(String currency, String amount) {

        WebElement usdButton = driver.findElement(By.id("pc_inDollars_true"));
        usdButton.click();

        WebElement currencyDropdown = driver.findElement(By.id("pc_currency"));
        Select selectCurrency = new Select(currencyDropdown);

        WebElement amountInput = driver.findElement(By.id("pc_amount"));

        if ((currency.equals("China"))&&(amount.equals("500"))){
            selectCurrency.selectByVisibleText("China (yuan)");
            amountInput.sendKeys("500");
        }else if((currency.equals("Norway"))&&(amount.equals("200"))){
            selectCurrency.selectByVisibleText("Norway (krone)");
            amountInput.sendKeys("200");
        }else if((currency.equals("Thailand (baht)"))&&(amount.equals("300"))){
            selectCurrency.selectByVisibleText("Thailand (baht)");
            amountInput.sendKeys("300");
        }

        WebElement purchaseButton = driver.findElement(By.id("purchase_cash"));
        purchaseButton.click();

    }

    @Then("User should successfully purchase foreign currency")
    public void user_should_successfully_purchase_foreign_currency() {

        wait = new WebDriverWait(driver, 10);

        WebElement successMessage = driver.findElement(By.id("alert_content"));
        Assert.assertTrue(successMessage.isDisplayed());

        WebElement makePaymentsMessage = driver.findElement(By.className("board-header"));
        Assert.assertTrue(makePaymentsMessage.isDisplayed());

        driver.quit();

    }
}
