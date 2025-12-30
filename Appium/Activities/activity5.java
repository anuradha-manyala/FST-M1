package activities;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class activity5 {

	public class Activity5 {
	    // Driver Declaration
	    AndroidDriver driver;
	    WebDriverWait wait;

	    // Set up method
	    @BeforeClass
	    public void setUp() throws MalformedURLException {
	        // Desired Capabilities
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("android");
	        options.setAutomationName("UiAutomator2");
	        options.setAppPackage("com.google.android.apps.messaging");
	        options.setAppActivity(".ui.ConversationListActivity");
	        options.noReset();

	        // Server Address
	        URL serverURL = new URL("http://localhost:4723/");

	        // Driver Initialization
	        driver = new AndroidDriver(serverURL, options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    // Test method
	    @Test
	    public void smsTest() {
	        // Find and click the add button
	        driver.findElement(AppiumBy.accessibilityId("Start chat")).click();

	        // Wait for elements to load
	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.xpath("//android.widget.EditText[@resource-id=\"ContactSearchField\"]")
	        ));

	        // Find the element to add recipient
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"ContactSearchField\"]")).sendKeys("999148292");
	        // Press ENTER
	        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

	        // Wait for textbox to appear
	        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Send to 999148292\"]")));
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Send to 999148292\"]")).click();
	        // Enter text to send
	        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium Test 6");
	        // Press Send
	        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();

	        // Assertion
	        String messageTextSent = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"message_text\"]")).getText();
	        assertEquals(messageTextSent, "Hello from Appium Test 6");
	    }

	    // Tear down method
	    @AfterClass
	    public void tearDown() {
	        // Close the app
	        driver.quit();
	    }
	}

}
