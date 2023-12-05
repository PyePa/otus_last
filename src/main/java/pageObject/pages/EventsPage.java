package pageObject.pages;

import data.EventsSortData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventsPage extends AbsBasePage {

    public EventsPage(WebDriver driver) {
        super(driver, "/");
    }

    @FindBy(css = ".dod_new-events__list.js-dod_new_events a") //каждая карточка
    private List<WebElement> eventsListLocator;

    @FindBy(css = ".dod_new-events__list.js-dod_new_events a .dod_new-type__text") //текст на карточке ОВ
    private List<WebElement> typeEventsLocator;

    @FindBy(css = ".dod_new-events__empty-message") //К сожалению, подходящих мероприятий не найдено.
    private WebElement emptyEventsLocator;

    public EventsPage checkSortByEvent(EventsSortData eventsSortData) {

        if (eventsListLocator.size() != 0) {
            for (WebElement element : eventsListLocator) {
                Assertions.assertTrue(element.isDisplayed());
            }
            for (WebElement element : typeEventsLocator) {
                Assertions.assertEquals(eventsSortData.getNamePage(), element.getText());
            }
        } else
            Assertions.assertTrue(emptyEventsLocator.isDisplayed());//К сожалению, подходящих мероприятий не найдено.
        return this;
    }
}