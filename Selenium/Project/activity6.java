package examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity6 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://alchemy.hguy.co/crm/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
    }

    @Test
    public void verifyActivitiesMenuExistsAndClickable() {

        // Wait until Activities menu is present and clickable
        WebElement activitiesMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='Activities']")
                )
        );

        // Hover over Activities menu
        Actions actions = new Actions(driver);
        actions.moveToElement(activitiesMenu).perform();

        // Assertions
        Assert.assertTrue(activitiesMenu.isDisplayed(),
                "Activities menu is not displayed");

        Assert.assertTrue(activitiesMenu.isEnabled(),
                "Activities menu is not clickable");

        System.out.println("Activities menu exists and is clickable");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
