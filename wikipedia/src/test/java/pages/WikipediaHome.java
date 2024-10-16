package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class WikipediaHome extends PageObject {

    private WebDriver driver;

    public WikipediaHome() {

        String pathChromeDriver = removeSubstringFromPath(System.getProperty("user.dir"), "wikipedia");
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", pathChromeDriver + "chromedriver-win64/chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", pathChromeDriver + "chromedriver-mac-x64/chromedriver");
        }

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        try {
            driver = new ChromeDriver(options);
            this.setDriver(driver);
        } catch (Exception e) {
            System.err.println("Error initializing the WebDriver: " + e.getMessage());
        }
    }

    public void openWikipedia() {
        try {
            driver.get("https://www.wikipedia.org");
        } catch (Exception e) {
            System.err.println("Error opening Wikipedia: " + e.getMessage());
        }
    }

    public void searchFor(String search) {
        WebElementFacade searchBox = find(By.name("search"));
        searchBox.type(search);
        searchBox.submit();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<String> getAllLinkTexts() {
        List<String> linkTexts = new ArrayList<>();
        for (WebElementFacade link : findAll(By.tagName("a"))) {
            linkTexts.add(link.getText());
        }
        return linkTexts;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static String removeSubstringFromPath(String originalPath, String substring) {
        if (originalPath.contains(substring)) {
            return originalPath.replace(substring, "");
        }
        return originalPath;
    }
}
