package component;

import data.menu.HeaderMenuItemData;
import data.menu.ISubMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPopup extends AbsBaseComponent{
    public HeaderPopup(WebDriver driver) {
        super(driver);
    }
    private String headerSubmenuPopupSelector = "[title='%s']";

    private String subMenuItemLocator = "//a[contains(@href,'%s') and contains(text(),'%s')]";
    private String сategorieSelector ="[class='header3__nav-item-popup-content']>div>div>a[href='%s']";

    private String hederMenuSelector ="[data-name='%s'].header3__nav-item";
    private String hedermenuPopupSelector ="[data-name='%s'].js-header3-popup";
    private String сategorieSelector1 ="[class='header3__nav-item-popup-content']>div>div>a[href='%s']";

    public HeaderPopup popupShouldBeVisible(HeaderMenuItemData headerMenuItemData) {

        String selector = String.format(headerSubmenuPopupSelector, headerMenuItemData.getName());
        webDriverWait.waitForAttributeNotContains($(By.cssSelector(selector)), "style", "none");
        return this;
    }

    public HeaderPopup clickSubMenuItemCoursesName(ISubMenu subMenuItemData,ISubMenu menuCategory) {

        String locator = String.format(subMenuItemLocator, subMenuItemData.getName(),menuCategory.getName());
        $(By.xpath(locator)).click();
        return this;
    }

    public  HeaderPopup moveToLearningTesting(ISubMenu subMenuItemData,ISubMenu menuCategory){
        String selector = String.format(subMenuItemLocator, subMenuItemData.getName(),menuCategory.getName());
        actionsMoveElement(driver.findElement(By.xpath(selector)));
        driver.findElement(By.xpath(selector)).click();
        return this;

    }
}