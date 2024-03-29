package HomeworkCucumberAssignment;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;


public class StepDefinitions {

    WebDriver driver;


    @Given("user goes to the {string}")
    public void user_goes_to_the(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Then("user waits for {int} seconds")
    public void user_waits_for_seconds(Integer seconds) throws InterruptedException {
        Thread.sleep(seconds * 100);
    }

    @Then("verifies that the page title contains the word {string}")
    public void verifies_that_the_page_title_contains_the_word(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Then("closes the page")
    public void closeTheBrowser() {
//        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot, "image/png", "screenshot-"+System.currentTimeMillis());
       driver.quit();
    }

}
