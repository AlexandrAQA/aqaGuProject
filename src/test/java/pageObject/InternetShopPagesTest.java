package pageObject;

import org.testng.annotations.Test;
import pageObject.pages.HomePage;

public class InternetShopPagesTest {
    @Test
    public void firstTest(){
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL("1a.lv");

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
        homePage.selectMenuItem("Datortehnika, preces birojam");
    }
}
