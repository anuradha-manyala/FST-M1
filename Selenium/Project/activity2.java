package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity2 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // a. Open the browser
        driver = new ChromeDriver();

        // b. Navigate to the website
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void getHeaderImageUrl() {

        // c. Locate the header image and get its URL
        WebElement headerImage = driver.findElement(
                By.xpath("//img[contains(@src,'company_logo')]")
        );

        String imageUrl = headerImage.getAttribute("src");

        // d. Print the URL to the console
        System.out.println("Header Image URL: " + imageUrl);
    }

    @AfterClass
    public void tearDown() {
        // e. Close the browser
        driver.quit();
    }
}
