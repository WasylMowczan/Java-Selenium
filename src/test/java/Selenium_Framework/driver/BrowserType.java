package Selenium_Framework.driver;

public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("internetexplorer");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
