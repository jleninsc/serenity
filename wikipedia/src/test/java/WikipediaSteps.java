import net.thucydides.core.annotations.Step;
import pages.WikipediaHome;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WikipediaSteps {

    WikipediaHome wikipediaHome = new WikipediaHome();

    @Step
    public void openWikipedia() {
        wikipediaHome.openWikipedia();
    }

    @Step
    public void searchFor(String search) {
        wikipediaHome.searchFor(search);
    }

    @Step
    public void verifyTitle(String expectedTitle) {
        String actualTitle = wikipediaHome.getPageTitle();
        System.out.println("Actual Title: " + actualTitle);
        assertEquals(expectedTitle, actualTitle, "Title does not match!");
    }

    @Step
    public void listAllLinkTexts() {
        for (String linkText : wikipediaHome.getAllLinkTexts()) {
            System.out.println("Link text: " + linkText);
        }
    }

    @Step
    public void closeDriver() {
        wikipediaHome.closeDriver();
    }
}
