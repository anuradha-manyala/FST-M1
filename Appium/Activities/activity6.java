package activities;
import static org.testng.Assert.assertEquals;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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


public class activity6 {
	
	AndroidDriver driver;
	WebDriverWait wait;
	
	//Set up method
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException{
		//Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
	    options.setAppActivity("com.google.android.apps.chrome.Main");
	    options.noReset();
	    
	    //Server address
	    URL serverURL = new URI("http://127.0.0.1:4723").toURL();
	    
	    //driver initialization
	    driver = new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/sliders");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Sliders\"]")));

	}
	@Test
	public void volume25Test() {
		//Get the screen dimensions
		Dimension dims = driver.manage().window().getSize();
		System.out.println(dims.getWidth() + "," + dims.getHeight());
		
		//Calculate the start and end points
		int startX = (int) (0.34 * dims.getWidth());
		int startY = (int) (0.72 * dims.getHeight());
		Point start = new Point(startX,startY);
		int endX = (int) (0.67 * dims.getWidth());
		int endY = (int) (0.72 * dims.getHeight());
		Point end = new Point(endX,endY);
		
		//Move the slider
		ActionsBase.doSwipe(driver, start, end, 1500);
		
		//Get the volume text and assert
		String volumeText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, '%')]")).getText();
		assertEquals(volumeText,"25%");
	}
	@Test
	public void volume75Test() {
		//Get the screen dimensions
		Dimension dims = driver.manage().window().getSize();
		System.out.println(dims.getWidth() + "," + dims.getHeight());
		
		//Calculate the start and end points
		int startX = (int) (0.67 * dims.getWidth());
		int startY = (int) (0.72 * dims.getHeight());
		Point start = new Point(startX,startY);
		int endX = (int) (0.34 * dims.getWidth());
		int endY = (int) (0.72 * dims.getHeight());
		Point end = new Point(endX,endY);
		
		//Move the slider
		ActionsBase.doSwipe(driver, start, end, 1500);
		
		//Get the volume text and assert
		String volumeText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, '%')]")).getText();
		assertEquals(volumeText,"75%");
	}
	@AfterClass
	public void teardown() {
		//Close the app
		driver.quit();
	}
}
