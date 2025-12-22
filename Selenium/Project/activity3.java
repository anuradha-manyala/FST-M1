package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity3 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // a. Open the browser
        driver = new ChromeDriver();

        // b. Navigate to the website
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void getCopyrightText() {

        // c. Get the first copyright text in the footer
        WebElement copyrightText = driver.findElement(
                By.xpath("(//a[@id='admin_options'])")
        );

        // d. Print the text to the console
        System.out.println("Copyright Text: " 
                + copyrightText.getText());
    }

    @AfterClass
    public void tearDown() {
        // e. Close the browser
        driver.quit();
    }
}
