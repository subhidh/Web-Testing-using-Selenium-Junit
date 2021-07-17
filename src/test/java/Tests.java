import static org.junit.Assert.assertEquals;

import drivers.DriverSingleton;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import pages.checkout;
import pages.homepage;
import pages.product;
import pages.signInPage;
import utility.FrameworkProperties;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {

    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static signInPage signInPage;
    static homepage homepage;
    static product product;
    static checkout checkout;

    @BeforeClass
    public static void initializeObjects() throws IOException {
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        driver = DriverSingleton.getDriver();
        homepage = new homepage();
        signInPage = new signInPage();
        checkout = new checkout();
        product = new product();
    }

    @Test
    public void test00testingAuthentication() throws IOException {
        driver.get("http://amazon.in");
        signInPage.login(frameworkProperties.getProperty("email"), frameworkProperties.getProperty("password"));
        assertEquals(frameworkProperties.getProperty("username"), homepage.getUserName());

    }

    @Test
    public void test01testingAddingThingsToCart() throws IOException {
        driver.get("http://amazon.in");
        product.search("Samsung Note 10");
        product.open();
        product.addToCart();
        product.search("iPhone 12");
        product.open();
        product.addToCart();
        checkout.openCart();
        assertEquals(frameworkProperties.getProperty("totalProducts"),checkout.countItems());

    }

    @AfterClass
    public static void closeObjects() {
        driver.close();
    }
}
