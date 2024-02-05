package pageObject.pages;

import org.openqa.selenium.By;
import pageObject.BaseFunc;

public class HomePage {
    private BaseFunc baseFunc;
    private final By ACCEPT_COOKIES_BTN
            = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    public HomePage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_COOKIES_BTN);
    }
}
