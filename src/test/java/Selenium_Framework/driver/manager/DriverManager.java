package Selenium_Framework.driver.manager;

import Selenium_Framework.driver.BrowserFactory;
import Selenium_Framework.driver.BrowserType;
import org.openqa.selenium.WebDriver;

import static Selenium_Framework.configuration.TestRunProperties.getBrowserToRun;
import static Selenium_Framework.configuration.TestRunProperties.getIsRemoteRun;
import static Selenium_Framework.driver.BrowserType.FIREFOX;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

    //Metoda służy od ustawiania typu przeglądarki dla danego wątku
    public static void setWebDriver(BrowserType browserType) {

        //Obiekt typu WebDriver, który w kolejnych liniach zostanie zainicjalizowany wywołaniem metody getBrowser() z klasy BrowserFactory
        WebDriver browser = null;

        //Jeśli obiekt browserType będzie nullem, wtedy dla danego wątku zostanie wybrana przeglądarka zdefiniowana
        // w pliku configuration.properties
        if (browserType == null) {

            //Utworzenie instancji WebDrivera dla opcji gdy browserType jest nullem
            //Zostanie wtedy wybrana przeglądarka zdefiniowana w pliku configuration.properties
            browserType = getBrowserToRun();
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        } else {
            //Utworzenie instancji WebDrivera dla opcji gdy browserType nie jest nullem
            //To znaczy, że został on zdefiniowany w pliku TestNG XML i możemy go używać
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }

        //Dodanie do puli instancji ThreadLocal za pomocą metody set() instancji klasy BrowserType
        browserTypeThreadLocal.set(browserType);

        //Dodanie do puli instancji ThreadLocal za pomocą metody set() instancji klasy WebDriver
        webDriverThreadLocal.set(browser);
    }

    public static WebDriver getWebDriver() {

        //Sprawdzamy czy wartość zmiennej WebDriver dla danego wątku jest nullem
        if (webDriverThreadLocal.get() == null) {
            //Wywołanie metody getBrowser() z klasy BrowserFactory zwraca instancję WebDrivera, który następnie jest
            //dodana do puli instancji klasy ThreadLocal za pomocą metody set()
            webDriverThreadLocal.set(new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser());
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {

        //Wywiłanie motody close() z klasy WebDrivera dla danego wątku
        webDriverThreadLocal.get().close();
        if (!getBrowserToRun().equals(FIREFOX)){
            webDriverThreadLocal.get().quit();
        }
        webDriverThreadLocal.remove();
    }
}
