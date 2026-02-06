package activities;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ActionsBaseTest {

    @SuppressWarnings("null")
	@Test
    public void testSwipeOnly() throws Exception {

    	UiAutomator2Options options = new UiAutomator2Options();
    	options.setPlatformName("Android");
    	options.setAutomationName("UiAutomator2"); 
        options.noReset();

        URL serverURL = new URI("http://127.0.0.1:4723").toURL();
        AndroidDriver driver = new AndroidDriver(serverURL, options);
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/sliders");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Sliders\"]")));

        Dimension dims = driver.manage().window().getSize();
        System.out.println(dims);

        Point start = new Point(
                (int)(0.50 * dims.getWidth()),
                (int)(0.70 * dims.getHeight())
        );
        System.out.println("Start: " + start);

        Point end = new Point(
                (int)(0.33 * dims.getWidth()),
                (int)(0.70 * dims.getHeight())
                
        );
        System.out.println("End: " + end);

        ActionsBase.doSwipe(driver, start, end, 1000);

        driver.quit();
    }
}
