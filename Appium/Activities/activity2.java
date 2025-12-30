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

public class activity2 {
	 // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
    	// Set the file
    	File appFile = new File("src/test/resources/Calculator.apk");
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.setApp(appFile.getAbsolutePath());
        options.noReset();

        // Server Address
//        URL serverURL = new URI("http://localhost:4723").toURL();
        URL serverURL = new URI("http://127.0.0.1:4723").toURL();

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        driver.get("https://training-support.net");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test method
    @Test
    public void testMethod() {
        // Locate and print/assert the Home page heading
    	String pageHeading = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
        assertEquals(pageHeading, "Training Support");
    	// Find and tap the About Us link
        driver.findElement(AppiumBy.accessibilityId("About Us")).click();       
//      Locate and print/assert the About page heading
        String aboutpageHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.TextView"))).getText();
        assertEquals(aboutpageHeading, "About Us");
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
//        driver.quit();
    }
}
