package aqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {
    WebDriver driver;
//    private final By REGISTRATION_FORM = By.id("registration");
//    private final By FIRST_NAME = By.id("NAME");
    private final By MENU_ITEM = By.xpath(".//li[contains(@class, 'submenu-lvl1__list-item--has-child')]");
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final String SECTION = "Instrumenti";

    @Test
    public void method(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://1a.lv");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        //0.find element
        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIES_BTN);
        //click on the element
        acceptBtn.click();

        //1. find all sections
        List<WebElement> menuItems = driver.findElements(MENU_ITEM);
        //2. find necessary section
        for (WebElement el : menuItems) {
            //System.out.println(el.getText());
            if(el.getText().equals(SECTION)){
                System.out.println(el.getText());
                    el.click();
            }
        }
        //3. click on it
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
