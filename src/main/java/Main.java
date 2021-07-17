import drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.checkout;
import pages.product;
import pages.signInPage;
import utility.FrameworkProperties;
import utility.utils;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        utils utils = new utils();
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("http://amazon.in");
        signInPage signInPage = new signInPage();
        signInPage.login(frameworkProperties.getProperty("email"), frameworkProperties.getProperty("password"));
        product product = new product();
        checkout checkout = new checkout();
        product.search("Samsung Note 10");
        product.open();
        product.addToCart();
        product.search("iPhone 12");
        product.open();
        product.addToCart();
        checkout.openCart();

    }
}
