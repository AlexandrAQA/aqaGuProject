package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.BaseFunc;

public class SubcategoriesPage {

    private final By SUBCATEGORY_NAME = By.xpath(".//span[@class='cat-title']");
    private BaseFunc baseFunc;

    public SubcategoriesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSubcategory (String subcategoryName) {
        for (WebElement elem : baseFunc.findElements(SUBCATEGORY_NAME)) {
            if (elem.getText().equals(subcategoryName)) {
                baseFunc.scrollToElement(elem);
               // elem.click();
                baseFunc.hardClick(elem);
                break;
            }
        }
    }
}
