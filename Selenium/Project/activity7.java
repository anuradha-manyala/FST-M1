package examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity7 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // a. Open site and login
        driver.get("https://alchemy.hguy.co/crm/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
    }

    @Test
    public void readPopupPhoneNumber() {

        // b. Navigate to Sales -> Leads
        WebElement salesMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='Sales']")
                )
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(salesMenu).perform();
        
        WebElement leadsOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@id='grouptab_0']/following-sibling::ul//li[.//a[normalize-space()='Leads']]")
                )
        );
        leadsOption.click();
     

        // c. Click the Additional Information icon (ⓘ) for the first lead
        WebElement infoIcon = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//span[contains(@title,'Additional Details')])[1]")
                )
        );
        infoIcon.click();

        // d. Read phone number from popup
        WebElement phoneNumber = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[contains(@class,'phone')]")
                )
        );
//
        System.out.println("Phone Number from popup: " + phoneNumber.getText());
    }

    @AfterClass
    public void tearDown() {
        // e. Close the browser
        driver.quit();
    }
}
