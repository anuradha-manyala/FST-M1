package examples;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity9 {

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
    public void printNamesAndUsersFromLeadsTable() {

        // ✅ Navigate directly to Leads page
        driver.get("https://alchemy.hguy.co/crm/index.php?module=Leads&action=index");

        // Wait for table to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("table.list.view")
        ));

        // Get all rows (excluding header)
        List<WebElement> rows = driver.findElements(
                By.xpath("//table[contains(@class,'list')]//tr[contains(@class,'oddListRowS1') or contains(@class,'evenListRowS1')]")
        );

        System.out.println("Printing first 10 Leads (Name | User):");

        int limit = Math.min(10, rows.size());

        for (int i = 0; i < limit; i++) {

            WebElement nameCell = rows.get(i)
                    .findElement(By.xpath(".//td[@field='name']//a"));

            WebElement userCell = rows.get(i)
                    .findElement(By.xpath(".//td[@field='assigned_user_name']//a"));

            System.out.println(
                    nameCell.getText() + " | " + userCell.getText()
            );
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
