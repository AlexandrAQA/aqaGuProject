package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseFunc {
    //this class works with browser window
    private WebDriver driver;

    public BaseFunc(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        }


    public void openURL(String url) {
        if(!url.startsWith("http://") && !url.startsWith("https://")){
            url = "http://" + url;
        }
        driver.get(url);
    }
}

