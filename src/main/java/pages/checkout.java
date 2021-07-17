package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkout {private WebDriver driver;

    public checkout() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-cart")
    private WebElement cartButton;

    @FindBy(xpath = "//span[@class='a-button-inner']")
    private WebElement checkout;

    @FindBy(xpath = "//a[@class='a-declarative a-button-text']")
    private WebElement deliverAddress;

    @FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
    private WebElement totalItems;

    public void openCart(){
        ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 1000);");
        cartButton.click();
    }

    public String countItems(){
        return totalItems.getText();
    }
    public void checkout(){
        checkout.click();
        checkout.click();
        checkout.click();
    }
}
