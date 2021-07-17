package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.utils;


public class product {
    private WebDriver driver;

    public product() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    utils utils = new utils();
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    private WebElement productLink;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(id = "productTitle")
    private WebElement productName;

    @FindBy(xpath = "//a[@class='a-size-medium a-link-normal a-text-bold a-text-italic']")
    private WebElement didYou;

    public void search(String productName){
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public void open(){
        if(driver.findElements(By.xpath("//a[@class='a-size-medium a-link-normal a-text-bold a-text-italic']") ).size() != 0) {
            driver.findElement(By.xpath("//a[@class='a-size-medium a-link-normal a-text-bold a-text-italic']")).click();
            ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 1000);");
        }
        productLink.click();
        ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 1000);");
    }
    public void addToCart(){
        utils.changeTab();
        addToCartButton.click();
        utils.closeTab();
    }
}

