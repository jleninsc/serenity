import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ListLinksTest {

    WikipediaSteps steps = new WikipediaSteps();

    @Test
    public void listAllLinks() {
        steps.openWikipedia();
        steps.searchFor("Microsoft");
        steps.listAllLinkTexts();
    }

    @AfterEach
    public void tearDown() {
        steps.closeDriver();
    }
}
