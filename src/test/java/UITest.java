import component.*;
import data.BrowserData;
import data.CategoryData;
import data.CoursesTestingData;
import data.EventsSortData;
import data.courses.CoursesDurationData;
import data.courses.CoursesFormatData;
import data.courses.CoursesSubTitleData;
import data.courses.CoursesTitleData;
import data.menu.HeaderMenuItemData;
import data.menu.MenuCategory;
import data.menu.SubMenuCategoryCourseItemData;
import exception.BrowserNorSupportedException;
import factories.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObject.pages.CoursePage;
import pageObject.pages.EventsPage;
import pageObject.pages.MainPage;


public class UITest {
    private org.apache.logging.log4j.Logger log = LogManager.getLogger(UITest.class);
    private WebDriver driver;


    @BeforeAll
    public static void setUpDriver() {
        new WebDriverFactory().setUp(BrowserData.CHROME);
    }

    @BeforeEach
    public void start() {
        driver = new WebDriverFactory().createDriver(BrowserData.CHROME);
    }

    @AfterEach
    public void shutdown() {
        if (driver != null) {
            driver.quit();
            log.info("Закрытие драйвера");
        }
    }

    @Test
    public void checkCountCoursesInQASectionTest() {
        log.info("Открыли главную страницу");
        new MainPage(driver).open();
        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);
        log.info("Открыли Обучение и перешли в Тестирование");
        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING)
                .clickSubMenuItemCoursesName(SubMenuCategoryCourseItemData.TESTING, MenuCategory.TEST);
        log.info("Проверяем выбран чекбокс Тестирование");
        new CourseFilterComponent(driver)
                .checkСourseFilterComponent(CategoryData.TESTING, true);
        log.info("Проверяем отображение курсов и их количество");
        new CourseCatalog(driver)
                .checkVisibleCourses()
                .checkCountCourses(10);
    }
    @Test
    public void checkCourseInfoTest() {
        String titleCourse = "Java QA Engineer. Professional";
        String subTitleCourse = "Прокачайте свои навыки автоматизации тестирования на Java";
        String durationCourse = "4 месяца";
        String formatCourse = "Онлайн";
        log.info("Открыли главную страницу");
        new MainPage(driver).open();
        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);
        log.info("Открыли Обучение и перешли в Тестирование");
        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING)
                .clickSubMenuItemCoursesName(SubMenuCategoryCourseItemData.TESTING, MenuCategory.TEST);
        log.info("Выбрали курс");
        new CourseCatalog(driver)
                .clickCourse(CoursesTestingData.JAVA_QA_PRO.getName());
        log.info("Проверяем информацию о курсе");
        new CoursePage(driver)
                .checkTitleCourse(titleCourse, CoursesTitleData.JAVA_QA_PRO)
                .checkSubTitleCourse(subTitleCourse, CoursesSubTitleData.JAVA_QA_PRO)
                .checkDurationCourse(durationCourse, CoursesDurationData.JAVA_QA_PRO)
                .checkFormatCourse(formatCourse, CoursesFormatData.JAVA_QA_PRO);

    }

    @Test
    public void checkEventsDateTest() {
        log.info("Открыли главную страницу");
        new MainPage(driver).open();
        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);
        log.info("Перешли в раздел Календарь мероприятий");
        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING)
                .clickSubMenuItemCoursesName(SubMenuCategoryCourseItemData.LESSON_CALENDAR, MenuCategory.EVENTS_CALENDAR);
        log.info("Проверяем отображение карточек и дату мероприятий");
        new EventsCatalog(driver)
                .checkVisibleEvents()
                .checkEventsDate();
    }

    @Test
    public void checkSortEventsTest() {
        log.info("Открыли главную страницу");
        new MainPage(driver).open();
        HeaderPopup headerSubMenuPopup = new HeaderPopup(driver);
        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);
        log.info("Перешли в раздел Календарь мероприятий");
        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING)
                .clickSubMenuItemCoursesName(SubMenuCategoryCourseItemData.LESSON_CALENDAR, MenuCategory.EVENTS_CALENDAR);
        log.info("Выставляем фильтр Открытый вебинар");
        new EventsCatalog(driver)
                .sortEvents(EventsSortData.OPENWEBINAR);
        log.info("Проверяем отображение мероприятий с пометкой Открытый вебинар");
        new EventsPage(driver)
                .checkSortByEvent(EventsSortData.OPENWEBINAR);

    }
}