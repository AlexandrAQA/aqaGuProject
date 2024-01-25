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

public class SeleniumTest {
    WebDriver driver;
//    private final By REGISTRATION_FORM = By.id("registration");
//    private final By FIRST_NAME = By.id("NAME");
//    private final By REGISTRATION_BTN = By.xpath(".//span[@class='smart-net-banner__info-button-text']");
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final String SECTION = "mobilais telefons samsung galaxy s24 ultra";

    @Test
    public void method(){
        driver = new ChromeDriver();
        driver.get("http://1a.lv");
        //driver.findElement(REGISTRATION_BTN).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        //find element
        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIES_BTN);
        //click on the element
        acceptBtn.click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
