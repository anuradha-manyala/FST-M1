package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity2 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // a. Open the browser
        driver = new ChromeDriver();

        // b. Navigate to the website
        driver.get("https://training-support.net/webelements/target-practice");
    }

    @Test
    public void testCase1() {
        // This test case will pass
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Selenium: Target Practice");
    }
 
    @Test
    public void testCase2() {
        // This test case will Fail
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
    }
 
    @Test(enabled = false)
    public void testCase3() {
        // This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }
 
    @Test
    public void testCase4() {
        // This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");
    }
 
    @AfterTest
    public void afterMethod() {
        // Close the browser
        driver.close();
    }
}