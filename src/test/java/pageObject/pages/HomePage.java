package pageObject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.BaseFunc;

import java.util.List;

public class HomePage {
    private BaseFunc baseFunc;
    private final By ACCEPT_COOKIES_BTN
            = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By MENU_ITEM = By.xpath(".//li/a[@class = 'submenu-lvl1__link' ]");
    private final By MENU =
            By.xpath(".//div[contains(@class, 'submenu-lvl1 submenu-lvl1--invisible submenu-lvl1--index')]");

    public HomePage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_COOKIES_BTN);
    }

    public void selectMenuItem(String menuItemName) {

        WebElement menuBlock = baseFunc.findElement(MENU);
        List<WebElement> items = menuBlock.findElements(MENU_ITEM);

        boolean isSectionFound = false;
        for (WebElement we : items) {
//            String SECTION = "Datortehnika, preces birojam";
            if (we.getText().equals(menuItemName)) {
                isSectionFound = true;
                we.click();
                break;
            }
        }
        Assertions.assertTrue(isSectionFound, "Menu item is not found" + menuItemName);
    }
}
