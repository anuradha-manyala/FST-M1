package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity1 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void titleTest() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "SuiteCRM", "Title does not match");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null && driver.getTitle().equals("SuiteCRM")) {
            driver.quit();
        }
    }
}
