package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.PassEncoder;


public class signInPage {
    private WebDriver driver;

    public signInPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-link-accountList")
    private WebElement accountList;

    @FindBy(id="ap_email")
    private WebElement emailField;

    @FindBy(id="continue")
    private WebElement continueButton;

    @FindBy(id="ap_password")
    private WebElement password;

    @FindBy(id="signInSubmit")
    private WebElement signInSubmit;


    public void login(String email, String pass){
        accountList.click();
        //((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 2000);");
        emailField.sendKeys(PassEncoder.decode64(email));
        continueButton.click();
        //((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 2000);");
        password.sendKeys(PassEncoder.decode64(pass));
        signInSubmit.click();
    }
    public void verifyOTP() {
        if (driver.findElements(By.id("auth-send-code")).size() != 0) {
            driver.findElement(By.id("auth-send-code")).click();
        }

        while (true) {
            if (driver.findElements(By.id("auth-signin-button")).size() != 0) {
                ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 10000);");
                driver.findElement(By.id("auth-signin-button")).click();
            } else if (driver.findElements(By.id("twotabsearchtextbox")).size() != 0) {
                break;
            }
        }

    }
}

