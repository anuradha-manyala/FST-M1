package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity4 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // a. Open the browser
        driver = new ChromeDriver();

        // b. Navigate to the site
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void loginTest() {

        // c. Find username and password fields
        driver.findElement(By.id("user_name"))
              .sendKeys("admin");

        driver.findElement(By.id("username_password"))
              .sendKeys("pa$$w0rd");

        // e. Click login
        driver.findElement(By.id("bigbutton")).click();

        // f. Verify homepage has opened
        String expectedTitle = "SuiteCRM";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle,
                "Home page did not open after login");
    }

    @AfterClass
    public void tearDown() {
        // g. Close the browser
        driver.quit();
    }
}
