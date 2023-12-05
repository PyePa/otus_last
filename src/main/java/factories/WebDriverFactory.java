package factories;

import data.BrowserData;
import exception.BrowserNorSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;

public class WebDriverFactory implements IFactory{
    private  String browserName  = System.getProperty("browser.name","chrome");


    @Override
    public WebDriver createDriver(BrowserData data) {
        switch (BrowserData.valueOf(browserName .trim().toUpperCase(Locale.ROOT))) {
            case CHROME : {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                return new ChromeDriver(chromeOptions);
            }
            case FIREFOX: {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--ignore-certificate-errors");
                return new FirefoxDriver(firefoxOptions);
            }

            default:
                String.format("Браузер %s не поддерживается",browserName);
                return null;
        }
    }

    @Override
    public WebDriverManager setUp(BrowserData data)  {
        switch (BrowserData.valueOf(browserName.toUpperCase())) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return null;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return null;
            default:
                String.format("Браузер %s не поддерживается",browserName);
                return null;
        }
    }
}