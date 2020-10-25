package com.wasylmowczan.SeleniumFramework.driver.manager;

import com.wasylmowczan.SeleniumFramework.driver.BrowserFactory;
import com.wasylmowczan.SeleniumFramework.driver.BrowserType;
import com.wasylmowczan.SeleniumFramework.driver.listeners.WebDriverEventListenerRegistrar;
import org.openqa.selenium.WebDriver;

import static com.wasylmowczan.SeleniumFramework.configuration.TestRunProperties.getBrowserToRun;
import static com.wasylmowczan.SeleniumFramework.configuration.TestRunProperties.getIsRemoteRun;
import static com.wasylmowczan.SeleniumFramework.driver.BrowserType.FIREFOX;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

    //Metoda służy od ustawiania typu przeglądarki dla danego wątku
    public static void setWebDriver(BrowserType browserType) {

            WebDriver browser = null;

            if (browserType == null) {
                browserType = getBrowserToRun();
                browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
            } else {
                browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
            }

            //Rejestracja obiektu WebDrivera
            browser = WebDriverEventListenerRegistrar.registerWebDriverEventListener(browser);

            browserTypeThreadLocal.set(browserType);
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
