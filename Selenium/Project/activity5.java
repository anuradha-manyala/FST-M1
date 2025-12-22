package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity5 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // a. Open the browser
        driver = new ChromeDriver();

        // b. Navigate to the site
        driver.get("https://alchemy.hguy.co/crm/");

        // Login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
    }

    @Test
    public void getNavigationMenuColor() {

        // c. Locate the navigation menu
        WebElement navMenu = driver.findElement(
                By.id("toolbar")
        );

        // Get background color
        String bgColor = navMenu.getCssValue("background-color");

        // Print color to console
        System.out.println("Navigation Menu Background Color: " + bgColor);
    }

    @AfterClass
    public void tearDown() {
        // d. Close the browser
        driver.quit();
    }
}
