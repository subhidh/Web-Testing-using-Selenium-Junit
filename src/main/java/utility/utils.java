package utility;

import drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class utils {
    private WebDriver driver;

    public utils() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    static int counter = 0;
    public void changeTab(){
        ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 1000);");
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(++counter));
        /*driver.close();
        driver.switchTo().window(newTb.get(0));
        System.out.println("Page title of parent window: " + driver.getTitle());*/
    }
    public void closeTab(){
        ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 1000);");
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(newTb.get(--counter));
        ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 1000);");
        driver.navigate().refresh();
    }
}
