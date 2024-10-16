import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class SearchWikipediaTest {

    WikipediaSteps steps = new WikipediaSteps();

    @Test
    public void searchForMicrosoft() {
        steps.openWikipedia();
        steps.searchFor("Microsoft");
        steps.verifyTitle("Microsoft");
    }

    @AfterEach
    public void tearDown() {
        steps.closeDriver();
    }
}
