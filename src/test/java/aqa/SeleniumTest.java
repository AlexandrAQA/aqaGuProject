package aqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class SeleniumTest {
    WebDriver driver;

    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By MENU_ITEM = By.xpath(".//li/a[@class = 'submenu-lvl1__link' ]");
    private final By MENU = By.xpath(".//div[contains(@class, 'submenu-lvl1 submenu-lvl1--invisible submenu-lvl1--index')]");
    final String expectedSitePage = "https://www.1a.lv/c/datortehnika-preces-birojam/2pd";

    @Test
    public void method() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://1a.lv");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        //0.find cookie element
        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIES_BTN);
        //click on the cookie element
        acceptBtn.click();

        //find menu item which contains elements
        WebElement menuBlock = driver.findElement(MENU);
        //create List items with menuBlock
        List<WebElement> items = menuBlock.findElements(MENU_ITEM);

        //foreach where we find 1 section and click on it
        for (WebElement we : items) {
            String SECTION = "Datortehnika, preces birojam";
            if (we.getText().equals(SECTION)) {
                wait.until(ExpectedConditions.elementToBeClickable(we));
                we.click();
                Assert.assertEquals(driver.getCurrentUrl(),expectedSitePage,
                        "User was not redirected to the page");
                break;
            }
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
