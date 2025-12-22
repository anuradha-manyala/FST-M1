package examples;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity8 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login
        driver.get("https://alchemy.hguy.co/crm/");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
    }

    @Test
    public void printOddRowsFromAccountsTable() {

        // b. Navigate to Sales -> Accounts
        WebElement salesMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='Sales']")
                )
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(salesMenu).perform();
        
        WebElement accountsOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@id='grouptab_0']/following-sibling::ul//li[.//a[normalize-space()='Accounts']]")
                )
        );
        accountsOption.click();
        // Wait for table to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("table.list.view")
        ));

        // Get all table rows (excluding header)
        List<WebElement> rows = driver.findElements(
                By.xpath("//table[contains(@class,'list')]//tr[contains(@class,'oddListRowS1') or contains(@class,'evenListRowS1')]")
        );

        System.out.println("Printing first 5 odd-numbered rows:");

        int printed = 0;

        // Loop through rows and print odd-numbered ones
        for (int i = 0; i < rows.size() && printed < 5; i++) {

            // Odd-numbered rows: index 0,2,4,6,8 → row 1,3,5,7,9
            if (i % 2 == 0) {
                WebElement accountName = rows.get(i)
                        .findElement(By.xpath(".//td[@field='name']//a"));

                System.out.println(accountName.getText());
                printed++;
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
