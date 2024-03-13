package pageObject;

import org.testng.annotations.Test;
import pageObject.pages.HomePage;
import pageObject.pages.SubcategoriesPage;

public class InternetShopPagesTest {
    @Test
    public void firstTest(){
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL("1a.lv");

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
        homePage.selectMenuItem("Mēbeles");

        SubcategoriesPage subcategoriesPage = new SubcategoriesPage(baseFunc);
        subcategoriesPage.selectSubcategory("Biroja mēbeles");
    }
}
