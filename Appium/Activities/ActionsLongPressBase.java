package activities;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.util.Arrays;

import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

import io.appium.java_client.AppiumDriver;

public class ActionsLongPressBase {
	// Set the pointer type
	private final static PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
	
	// Create the swipe action
	public static void doLongPress(AppiumDriver driver, Point start, Point end, int duration) {
		// Create the sequence of actions
		Sequence longpress = new Sequence(finger, 1);
		System.out.println("Swipe called");
		longpress.addAction(finger.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()));
		longpress.addAction(finger.createPointerDown(0));
		longpress.addAction(new Pause(finger,ofMillis(2000)));
//		swipe.addAction(finger.createPointerMove(ofMillis(0), viewport(), end.getX(), end.getY()));
		longpress.addAction(finger.createPointerUp(0));
		System.out.println("Performing swipe");
	//Perform the actions
	driver.perform(Arrays.asList(longpress));	
	System.out.println("LongPress performed");
	}
}
