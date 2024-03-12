package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseFunc {

    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

    public void openURL(String url) {
        if(!url.startsWith("http://") && !url.startsWith("https://")){
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void click(By locator){

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public WebElement findElement(By locator){
       return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
}

