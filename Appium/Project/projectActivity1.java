package activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class projectActivity1 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
    	// Set the file
    	File appFile = new File("src/test/resources/ts-todo-list-v1.apk");
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setApp(appFile.getAbsolutePath());
        options.noReset();

        // Server Address
//        URL serverURL = new URI("http://localhost:4723").toURL();
        URL serverURL = new URI("http://127.0.0.1:4723").toURL();

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));       

    }

    @Test
    public void addTask1() {
        // Complete Activity1
        driver.findElement(AppiumBy.id("fab_new_task")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/dialog_title\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.app.todolist:id/et_new_task_name\"]")).sendKeys("Activity4");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_new_task_priority\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"High\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_new_task_ok\"]")).click();

    }
    @Test
    public void addTask2() {
    	 // Complete Activity2
        driver.findElement(AppiumBy.id("fab_new_task")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/dialog_title\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.app.todolist:id/et_new_task_name\"]")).sendKeys("Activity5");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_new_task_priority\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Medium\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_new_task_ok\"]")).click();

    }

    @Test
    public void addTask3() {
    	 // Complete Activity3
        driver.findElement(AppiumBy.id("fab_new_task")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/dialog_title\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.app.todolist:id/et_new_task_name\"]")).sendKeys("Activity6");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_new_task_priority\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Low\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_new_task_ok\"]")).click();

    }
    
    @Test
    public void verifyAllTasksAdded() {

        // Verify Activity4 exists
        Assert.assertTrue(driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Activity4']")).size() > 0, "Activity4 task was not added");

        // Verify Activity5 exists
        Assert.assertTrue(driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Activity5']")).size() > 0, "Activity5 task was not added");

        // Verify Activity6 exists
        Assert.assertTrue(driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Activity6']")).size() > 0, "Activity6 task was not added");
        
    }
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}